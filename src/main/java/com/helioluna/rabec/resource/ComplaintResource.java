package com.helioluna.rabec.resource;

import com.helioluna.rabec.domain.Complaint;
import com.helioluna.rabec.service.complaint.ComplaintService;
import com.helioluna.rabec.util.interfaces.Save;
import com.helioluna.rabec.util.interfaces.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complaint")
@CrossOrigin(origins = "*")
public class ComplaintResource {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<Complaint> save(@RequestBody @Validated({Save.class}) Complaint complaint) {
        Complaint createdComplaint = complaintService.save(complaint);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComplaint);
    }

    @PutMapping
    public ResponseEntity<Complaint> update(@RequestBody @Validated({Update.class}) Complaint complaint) {
        Complaint updatedComplaint = complaintService.update(complaint);
        return ResponseEntity.ok(updatedComplaint);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Complaint>> getById(@PathVariable("id") String id) {
        Optional<Complaint> complaint = complaintService.getById(id);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> listAll() {
        List<Complaint> complaint = complaintService.listAll();
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/city/{idCity}/company/{idCompany}")
    public ResponseEntity<List<Complaint>> findByCityAndCompany(@PathVariable("idCity") String idCity,@PathVariable("idCompany") String idCompany ) {
        List<Complaint> complaints = complaintService.findByCityAndCompany(idCity, idCompany);
        return ResponseEntity.ok(complaints);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if(!isComplaintExist(id)) {
            return ResponseEntity.badRequest().body("Register not found id:" + id);
        }
        complaintService.delete(id);
        return ResponseEntity.ok("Record " + id +" remove.");
    }

    private Boolean isComplaintExist(String id) {
        Optional<Complaint> complaintOptional = complaintService.getById(id);
        return (complaintOptional.isPresent()) ? true: false;
    }

}
