package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
