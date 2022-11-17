package com.example.ceneo.api;

import com.example.ceneo.entity.FeatureFlags;
import com.example.ceneo.entity.Product;
import com.example.ceneo.service.implementation.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductApi {
    private final ProductServiceImpl productService;

    @PostMapping("/save")
    public void saveProductList(@RequestBody List<Product> product){
             productService.addProductList(product);
    }

    @PostMapping("/saveOne")
    public void saveOneProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/listAll")
    public List<Product> listAllProducts(){
       return productService.listAllProducts();
    }

    @GetMapping("/listByCategory/{category}")
    public List<Product> listALlProductsByCategory(@PathVariable("category")String category){
        return productService.listProductsByCategory(category);
    }

}
