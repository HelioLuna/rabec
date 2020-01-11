package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {
    List<Complaint> findAllByLocale_IdAndCompany_Id(String idCity, String idCompany);
}
