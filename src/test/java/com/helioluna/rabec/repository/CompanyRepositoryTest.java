package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;
    Company company = new Company(null, "WALLMART");

    @Test
    public void saveTest(){
        Company createdCompany = companyRepository.save(company);
        company.setId(createdCompany.getId());
        assertThat(createdCompany.getId()).isNotNull();
    }

    @Test
    public void updateTest(){
        String name = "The Wallmart";
        company.setName(name);
        Company updatedCompany = companyRepository.save(company);

        assertThat(updatedCompany.getName()).isEqualTo(name);
    }

    @Test
    public void getByIdTest(){
        Optional<Company> result = companyRepository.findById("imaginaryID");
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    public void listAllTest(){
        List<Company> companies = companyRepository.findAll();
        assertThat(companies.size()).isNotZero();
    }

}
