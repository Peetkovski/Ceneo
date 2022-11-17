package com.example.ceneo.repository;

import com.example.ceneo.entity.FeatureFlags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureFlagsRepository extends JpaRepository<FeatureFlags, Long> {
}
