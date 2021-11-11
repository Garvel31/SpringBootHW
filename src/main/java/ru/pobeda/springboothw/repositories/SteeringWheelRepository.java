package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Car;

import ru.pobeda.springboothw.entities.SteeringWheel;

import java.util.List;

public interface SteeringWheelRepository extends CrudRepository<SteeringWheel, Long> {

    List<SteeringWheel> findSteeringWheelById(Long id);
    List<SteeringWheel> findAll();


}
