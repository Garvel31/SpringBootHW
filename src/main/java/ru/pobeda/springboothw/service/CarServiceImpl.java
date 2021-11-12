package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pobeda.springboothw.entities.*;
import ru.pobeda.springboothw.repositories.CarRepository;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    public CarServiceImpl() {

    }

    @Override
    public Car addCar(String mnfName, String modelName, String engineType) {
        final Car newCar = new Car(mnfName, modelName);

        final SteeringWheel steeringWheel = new SteeringWheel(String.join(" ", newCar.getMnfName(), newCar.getModelName(), "steering wheel"));
        newCar.setSteeringWheel(steeringWheel);

        Engine engine = new Engine(engineType);
        for (int i = 5; i <= 10; i++) {
            final Gear gear = new Gear(i);
            gear.setEngine(engine);
            engine.getGears().add(gear);
        }
        newCar.setEngine(engine);

        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + engineType);
        engine.getManual().add(cylinderHeadManual);
        cylinderHeadManual.getEngines().add(engine);


        return carRepository.save(newCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public void updateCar(Long id, String mnfName, String modelName, Engine engine) {
        List<Car> newCar = carRepository.findCarById(id);
        newCar.get(0).setMnfName(mnfName);
        newCar.get(0).setModelName(modelName);
        newCar.get(0).setEngine(engine);
        carRepository.save(newCar.get(0));
    }

}

