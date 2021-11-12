package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.entities.SteeringWheel;
import ru.pobeda.springboothw.repositories.CarRepository;
import ru.pobeda.springboothw.repositories.EngineRepository;
import ru.pobeda.springboothw.repositories.SteeringWheelRepository;

public class SteeringWheelServiceImpl implements SteeringWheelService {


    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public SteeringWheel addSteeringWheel(String type) {
        final SteeringWheel newSW = new SteeringWheel(type);

        return steeringWheelRepository.save(newSW);
    }

    public void deleteSTWheel(Long id) {
        Car newCar = carRepository.findCarBySteeringWheelId(id);
        newCar.setSteeringWheel(null);
        steeringWheelRepository.deleteById(id);
    }
}
