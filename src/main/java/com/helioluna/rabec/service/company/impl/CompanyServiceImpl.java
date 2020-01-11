package com.helioluna.rabec.service.company.impl;

import com.helioluna.rabec.domain.Company;
import com.helioluna.rabec.repository.CompanyRepository;
import com.helioluna.rabec.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) { return this.companyRepository.save(company); }

    @Override
    public Company update(Company company) { return this.companyRepository.save(company); }

    @Override
    public Optional<Company> getById(String id) { return this.companyRepository.findById(id); }

    @Override
    public List<Company> listAll() { return this.companyRepository.findAll(); }

    @Override
    public void delete(String id) { this.companyRepository.deleteById(id); }
}
