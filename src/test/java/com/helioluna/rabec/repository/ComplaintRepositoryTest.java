package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.City;
import com.helioluna.rabec.domain.Company;
import com.helioluna.rabec.domain.Complaint;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplaintRepositoryTest {
    @Autowired
    ComplaintRepository complaintRepository;
    Complaint complaint = new Complaint(null, "MEU PRODUTO NÃO CHEGOU", new City("5e195cf5dc99e03dbb08d676", "Recife"), new Company("5e195d78dc99e03dbb08d677", "LOJAS AMERICANAS"));

    @AfterAll
    @Test
    public void cleanUp() {
        complaintRepository.deleteAll();
    }

    @Test
    public void saveTest(){
        Complaint createdComplaint = complaintRepository.save(complaint);
        complaint.setId(createdComplaint.getId());
        assertThat(createdComplaint.getId()).isNotNull();
    }

    @Test
    public void updateTest(){
        String dsc = "MEU PRODUTO NÃO CHEGOU NA DATA PREVISTA";
        complaint.setDescription(dsc);
        Complaint updatedComplaint = complaintRepository.save(complaint);

        assertThat(updatedComplaint.getDescription()).isEqualTo(dsc);
    }

    @Test
    public void getByIdTest(){
        Optional<Complaint> result = complaintRepository.findById("imaginaryID");
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    public void listAllTest(){
        List<Complaint> complaints = complaintRepository.findAll();
        assertThat(complaints.size()).isNotZero();
    }

    @Test
    public void findByCityAndCompanyTest(){
        List<Complaint> complaints = complaintRepository.findAllByLocale_IdAndCompany_Id("5e195cf5dc99e03dbb08d676","5e195d78dc99e03dbb08d677");
        assertThat(complaints.size()).isNotZero();
    }
}
