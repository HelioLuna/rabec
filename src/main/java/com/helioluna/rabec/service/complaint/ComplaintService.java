package com.helioluna.rabec.service.complaint;

import com.helioluna.rabec.domain.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ComplaintService {
    Complaint save(Complaint complaint);
    Complaint update(Complaint complaint);
    Optional<Complaint> getById(String id);
    List<Complaint> listAll();
    void delete(String id);
    List<Complaint> findByCityAndCompany(String idCity, String idCompany);
}
