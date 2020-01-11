package com.helioluna.rabec.service.city.impl;

import com.helioluna.rabec.domain.City;
import com.helioluna.rabec.repository.CityRepository;
import com.helioluna.rabec.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City save(City city) { return this.cityRepository.save(city); }

    @Override
    public City update(City city) { return this.cityRepository.save(city); }

    @Override
    public Optional<City> getById(String id) { return this.cityRepository.findById(id); }

    @Override
    public List<City> listAll() { return this.cityRepository.findAll(); }

    @Override
    public void delete(String id) { this.cityRepository.deleteById(id); }
}
