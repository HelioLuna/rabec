package com.helioluna.rabec.service.complaint.impl;

import com.helioluna.rabec.domain.Complaint;
import com.helioluna.rabec.repository.ComplaintRepository;
import com.helioluna.rabec.service.complaint.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Complaint save(Complaint complaint) {
        return this.complaintRepository.save(complaint);
    }

    @Override
    public Complaint update(Complaint complaint) {
        return this.complaintRepository.save(complaint);
    }

    @Override
    public Optional<Complaint> getById(String id) {
        return this.complaintRepository.findById(id);
    }

    @Override
    public List<Complaint> listAll() { return this.complaintRepository.findAll(); }

    @Override
    public void delete(String id) { this.complaintRepository.deleteById(id); }

    @Override
    public List<Complaint> findByCityAndCompany(String idCity, String idCompany) {
        return this.complaintRepository.findAllByLocale_IdAndCompany_Id(idCity, idCompany);
    }

}
