package com.example.ceneo.entity;

import com.example.ceneo.entity.enums.Categories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private double productPrice;
    private double productPriceOriginal;
    private String productCode;
    private String productProducer;
    private String productPage;
    private String linkUrl;
    private String imageUrl;
    private String productCategory;
    @CreationTimestamp
    private Date insertedDate;
}
