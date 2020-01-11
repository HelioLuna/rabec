package com.helioluna.rabec.resource;

import com.helioluna.rabec.domain.City;
import com.helioluna.rabec.service.city.CityService;
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
@RequestMapping("/api/city")
@CrossOrigin(origins = "*")
public class CityResource {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<City> save(@RequestBody @Validated({Save.class}) City city) {
        City createdCity = cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

    @PutMapping
    public ResponseEntity<City> update(@RequestBody @Validated({Update.class}) City city) {
        City updatedCity = cityService.update(city);
        return ResponseEntity.ok(updatedCity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> getById(@PathVariable("id") String id) {
        Optional<City> city = cityService.getById(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/all")
    public ResponseEntity<List<City>> listAll() {
        List<City> cities = cityService.listAll();
        return ResponseEntity.ok(cities);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if(!isCityExist(id)) {
            return ResponseEntity.badRequest().body("Register not found id:" + id);
        }
        cityService.delete(id);
        return ResponseEntity.ok("Record " + id +" remove.");
    }

    private Boolean isCityExist(String id) {
        Optional<City> cityOptional = cityService.getById(id);
        return (cityOptional.isPresent()) ? true: false;
    }
}
