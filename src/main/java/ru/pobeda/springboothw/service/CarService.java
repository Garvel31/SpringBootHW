package ru.pobeda.springboothw.service;

import ru.pobeda.springboothw.entities.Car;

public interface CarService {
    Car addCar(String mnfName, String modelName, String engineType);
}
