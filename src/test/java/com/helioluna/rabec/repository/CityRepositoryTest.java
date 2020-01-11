package com.helioluna.rabec.repository;

import com.helioluna.rabec.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {

    @Autowired
    CityRepository cityRepository;
    City city = new City(null, "Maceio");

    @Test
    public void saveTest(){
        City createdCity = cityRepository.save(city);
        city.setId(createdCity.getId());
        assertThat(createdCity.getId()).isNotNull();
    }

    @Test
    public void updateTest(){
        String name = "Maceió";
        city.setName(name);
        City updatedCity = cityRepository.save(city);

        assertThat(updatedCity.getName()).isEqualTo(name);
    }

    @Test
    public void getByIdTest(){
        Optional<City> result = cityRepository.findById("imaginaryID");
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    public void listAllTest(){
        List<City> cities = cityRepository.findAll();
        assertThat(cities.size()).isNotZero();
    }

}
