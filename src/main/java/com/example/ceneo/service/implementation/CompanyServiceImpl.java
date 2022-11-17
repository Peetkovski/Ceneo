package com.example.ceneo.service.implementation;

import com.example.ceneo.entity.Company;
import com.example.ceneo.repository.CompanyRepository;
import com.example.ceneo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public boolean registerCompany(Company company) {
        company.setCompanyId(company.getCompanyId());
        company.setCompanyName(company.getCompanyName());
        company.setCompanyCodeId(company.getCompanyCodeId());
        companyRepository.save(company);
        return true;
    }

    @Override
    public Optional<Company> getCompanyInformations(String companyCodeId) {
        return Optional.ofNullable(companyRepository
                .findCompanyByCompanyCodeId(companyCodeId)
                .orElseThrow(NullPointerException::new));
    }

}
