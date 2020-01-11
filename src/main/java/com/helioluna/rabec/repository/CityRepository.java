package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
