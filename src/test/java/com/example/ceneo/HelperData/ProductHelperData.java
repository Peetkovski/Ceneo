package com.example.ceneo.HelperData;

import com.example.ceneo.entity.Product;
import com.example.ceneo.entity.enums.Categories;

import java.util.List;
import java.util.Random;

public class ProductHelperData {


    public static List<Product> correctProductListData(){
            Product product = Product
                .builder()
                .productId(1L)
                .productName("Product Name")
                .productCode(generateProductCode())
                .productPrice(35.14)
                    .productProducer("producer")
                .productCategory("es")
                .build();
        Product product2 = Product
                .builder()
                .productId(1L)
                .productName("Product Name")
                .productProducer("producer")

                .productCode(generateProductCode())
                .productPrice(35.14)
                .productCategory("es")
                .build();
            return List.of(product);
    }
   public static Product correctProductData(){
        return Product
                .builder()
                .productId(1L)
                .productName("Product Name")
                .productCode(generateProductCode())
                .productPrice(35.14)
                .productProducer("essa")
                .productCategory("es")
                .build();
    }

    public static Product productDataMissingProductName(){
        return Product
                .builder()
                .productId(1L)
                .productName(null)
                .productCode(generateProductCode())
                .productPrice(35.14)
                .productCategory("food")
                .build();
    }

    private static String generateProductCode(){
        Random random = new Random();
        String productCode = "";
        String productCodePartOne = String.format("%04d", random.nextInt(10000));
        String productCodePartTwo = String.format("%04d" , random.nextInt(10000));
        productCode = productCodePartOne + "-" + productCodePartTwo;
        return productCode;
    }
}
