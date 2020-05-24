package student_system.service;

import student_system.entity.City;

import java.util.List;

public interface CityService {
    List<City> findAll();

    void save(City city);
}
