package com.example.ceneo.service.implementation;

import com.example.ceneo.entity.FeatureFlags;
import com.example.ceneo.repository.FeatureFlagsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class FeatureFlagsServiceImpl {

    private final FeatureFlagsRepository featureFlagsRepository;
    public void readFromFile(List<FeatureFlags> featureFlags){

        featureFlagsRepository.saveAll(featureFlags);
    }
}
