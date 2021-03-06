package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    Car findCarByEngineId(Long engineId);
    Car findCarBySteeringWheelId(Long stwId);
    List<Car> findCarByMnfName(String mnfName);
    List<Car> findCarById(Long id);
    List<Car> findAll();


}
