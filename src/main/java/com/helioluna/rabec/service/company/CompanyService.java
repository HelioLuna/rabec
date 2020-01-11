package com.helioluna.rabec.service.company;

import com.helioluna.rabec.domain.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CompanyService {
    Company save(Company company);
    Company update(Company company);
    Optional<Company> getById(String id);
    List<Company> listAll();
    void delete(String id);
}