package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Gear;
import ru.pobeda.springboothw.repositories.GearRepository;

import java.util.List;

public class GearServiceImpl implements GearService {

    @Override
    public Gear addGear(int size) {
        return null;
    }

    @Autowired
    private GearRepository gearRepository;

    @Override
    public Gear findGear(Car car) {
        return gearRepository.findGearByEngineId(car.getEngine().getId());
    }

    @Override
    public List<Gear> findGears(Car car) {
        return gearRepository.findGearsByEngineId(car.getEngine().getId());
    }
}
