package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entity.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarByMnfName(String mnfName);
    List<Car> findCarById(Long id);
    List<Car> findAll();


}
