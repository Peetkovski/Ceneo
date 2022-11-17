package com.example.ceneo.service.implementation;

import com.example.ceneo.entity.Company;
import com.example.ceneo.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    CompanyServiceImpl companyService;

    @Mock
    CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
        companyService = new CompanyServiceImpl(companyRepository);
    }

    @Test
    void registerCompany() {
        Company registeredCompany = new Company();
        registeredCompany.setCompanyName("Company Name");
        registeredCompany.setCompanyCodeId("12432634");
        companyService.registerCompany(registeredCompany);
        ArgumentCaptor<Company> argumentCaptor =
                ArgumentCaptor.forClass(Company.class);
        Mockito.verify(companyRepository)
                .save(argumentCaptor.capture());
        Company capturedCompany = argumentCaptor.getValue();
        assertEquals(capturedCompany, registeredCompany);
    }

    @Test
    void getCompanyInformations() {
        Optional<Company> company = Optional.of(new Company());
        Optional<Company> companyInformationsRepository
                = companyRepository.findCompanyByCompanyCodeId("123");
        Optional<Company> companyInformationsService
                = companyService.getCompanyInformations("123");
        assertEquals(companyInformationsRepository, companyInformationsService);
    }
}