package com.example.ceneo.service.implementation;

import com.example.ceneo.entity.FeatureFlags;
import com.example.ceneo.entity.Product;
import com.example.ceneo.entity.enums.Categories;
import com.example.ceneo.repository.ProductRepository;
import com.example.ceneo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public void addProductList(List<Product> productList) {
        productList.stream()
                        .forEach(products -> {
                                    productNameIsNotNull(products.getProductName());
                                    productProducerIsNotNull(products.getProductProducer());
                                    products.setProductCode(generateProductCode());
                                    productRepository.save(products);
                                }
                        );

    }

    @Override
    public boolean addProduct(Product product) {
        if(productProducerIsNotNull(product.getProductProducer())) {
            product.setProductName(product.getProductName());
            product.setProductProducer(product.getProductProducer());
            product.setProductCategory(product.getProductCategory());
            product.setProductCode(product.getProductCode());
            product.setProductPrice(product.getProductPrice());
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> listProductsByCategory(String productCategory) {
        return productRepository.getProductsByProductCategory(productCategory);
    }

    @Override
    public boolean deleteProduct(String productCode) {
        Optional<Product> product
                = Optional
                .ofNullable(productRepository.getProductByProductCode(productCode)
                .orElseThrow(NullPointerException::new));

        productRepository.delete(product.get());
        return true;
    }

    @Override
    public boolean updateProduct(String productCode, Product product) {
        return false;
    }



    @Override
    public Optional<Product> getOneProduct(String productCode) {
        return Optional.ofNullable(productRepository.getProductByProductCode(productCode)).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Product> showAllProductsFromCompany(String companyCode) {
        return null;
    }

    private boolean allProductInfoRequired(Product product){
        if (productNameIsNotNull(product.getProductName())) {
            return true;
        }
        else return false;
    }

    private boolean productProducerIsNotNull(String productProducer){
        if (productProducer != null){
            return true;
        }
        else {
            throw new NullPointerException("Product producer is null!");
        }
    }
    private boolean productNameIsNotNull(String productName){
        if(productName != null) {
            return true;
        }
        else {
            throw new NullPointerException("Product name is null!");
        }
    }

    private String generateProductCode(){
        Random random = new Random();
        String productCode = "";
        String productCodePartOne = String.format("%04d", random.nextInt(10000));
        String productCodePartTwo = String.format("%04d" , random.nextInt(10000));
        productCode = productCodePartOne + "-" + productCodePartTwo;
        return productCode;
    }
}

