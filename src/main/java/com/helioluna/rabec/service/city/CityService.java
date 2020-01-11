package com.helioluna.rabec.service.city;

import com.helioluna.rabec.domain.City;
import java.util.List;
import java.util.Optional;

public interface CityService {
    City save(City city);
    City update(City city);
    Optional<City> getById(String id);
    List<City> listAll();
    void delete(String id);
}
