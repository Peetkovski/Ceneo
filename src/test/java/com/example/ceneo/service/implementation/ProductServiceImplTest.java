package com.example.ceneo.service.implementation;

import com.example.ceneo.HelperData.ProductHelperData;
import com.example.ceneo.entity.Product;
import com.example.ceneo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void addProductList() {
        List<Product> newProduct = ProductHelperData.correctProductListData();
        productService.addProductList(newProduct);
        ArgumentCaptor<Product> argumentCaptor =
                ArgumentCaptor.forClass(Product.class);
        Mockito.verify(productRepository)
                .save(argumentCaptor.capture());
        Product capturedProduct = argumentCaptor.getValue();
        List.of(capturedProduct);
        //TODO POPRAW TEN TEST!!!!
        assertEquals(capturedProduct, newProduct.get(0));
    }

    @Test
    void addSingleProduct() {
        Product newProduct = ProductHelperData.correctProductData();
        productService.addProduct(newProduct);
        ArgumentCaptor<Product> argumentCaptor =
                ArgumentCaptor.forClass(Product.class);
        Mockito.verify(productRepository)
                .save(argumentCaptor.capture());
        Product capturedProduct = argumentCaptor.getValue();
        assertEquals(capturedProduct, newProduct);
    }


    @Test
    void throwNullPointerExceptionAddProduct(){
        Product newProduct = ProductHelperData.productDataMissingProductName();
        newProduct.setProductName(null);
        newProduct.setProductCode("16346");
        newProduct.setProductPrice(5);
        newProduct.setProductCategory("Food");

        assertThatThrownBy(
                () ->productService.addProduct(newProduct))
         .isInstanceOf(NullPointerException.class)
         .hasMessageContaining("Product name is null!");
    }

    @Test
    void listAllProducts(){
        List<Product> productList = productService.listAllProducts();
        List<Product> productsListRepo = productRepository.findAll();
        assertEquals(productList, productsListRepo);
    }

    @Test
    void getOneProduct(){

    }

}