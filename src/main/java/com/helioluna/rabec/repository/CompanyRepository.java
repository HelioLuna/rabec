package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
