package com.example.ceneo.service;

import com.example.ceneo.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyService {
    boolean registerCompany(Company company);
    Optional<Company> getCompanyInformations(String companyCodeId);
}
