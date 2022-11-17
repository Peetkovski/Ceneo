package com.example.ceneo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeatureFlags {
    @Id
    @GeneratedValue
    private Long featureId;
    private String featureName;
    private boolean turnedOn;

}
