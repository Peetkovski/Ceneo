package com.example.ceneo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHistory {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private double productPrice;
    private String productCode;
    private String productProducer;
    private String linkUrl;
    private String imageUrl;
    private String productCategory;
    @CreationTimestamp
    private Date insertedDate;
}
