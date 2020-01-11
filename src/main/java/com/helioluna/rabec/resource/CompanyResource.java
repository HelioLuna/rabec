package com.helioluna.rabec.resource;


import com.helioluna.rabec.domain.Company;
import com.helioluna.rabec.service.company.CompanyService;
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
@RequestMapping("/api/company")
@CrossOrigin(origins = "*")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody @Validated({Save.class}) Company company) {
        Company createdCompany = companyService.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    @PutMapping
    public ResponseEntity<Company> update(@RequestBody @Validated({Update.class}) Company company) {
        Company updatedCompany = companyService.update(company);
        return ResponseEntity.ok(updatedCompany);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getById(@PathVariable("id") String id) {
        Optional<Company> company = companyService.getById(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> listAll() {
        List<Company> companies = companyService.listAll();
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if(!isCompanyExist(id)) {
            return ResponseEntity.badRequest().body("Register not found id:" + id);
        }
        companyService.delete(id);
        return ResponseEntity.ok("Record " + id +" remove.");
    }

    private Boolean isCompanyExist(String id) {
        Optional<Company> companyOptional = companyService.getById(id);
        return (companyOptional.isPresent()) ? true: false;
    }
}
