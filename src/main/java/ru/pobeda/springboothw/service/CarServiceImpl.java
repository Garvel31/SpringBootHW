package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.repositories.CarRepository;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;



    public CarServiceImpl() {

    }

    @Override
    public Car addCar(String mnfName, String modelName, String engineType) {
        final  Car newCar = new Car(mnfName, modelName);
        Engine engine = new Engine(engineType);
        newCar.setEngine(engine);
        return carRepository.save(newCar);
    }
}
