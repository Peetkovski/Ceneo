package com.example.ceneo.repository;

import com.example.ceneo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByCompanyCodeId(String companyCodeId);
}
