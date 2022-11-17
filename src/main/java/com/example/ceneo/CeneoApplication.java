package com.example.ceneo;

import com.example.ceneo.entity.FeatureFlags;
import com.example.ceneo.repository.ProductRepository;
import com.example.ceneo.service.scraping.ScrappingProduct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.in;

@SpringBootApplication
public class CeneoApplication {


    public static void main(String[] args) {
        SpringApplication.run(CeneoApplication.class, args);

    }

}
