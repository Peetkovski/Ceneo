package com.example.ceneo.service;

import com.example.ceneo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProductList(List<Product> productList);
    boolean addProduct(Product product);

    List<Product> listAllProducts();
    List<Product> listProductsByCategory(String productCategory);
    boolean deleteProduct(String productCode);
    boolean updateProduct(String productCode, Product product);
    Optional<Product> getOneProduct(String productCode);
    List<Product> showAllProductsFromCompany(String companyCode);

}
