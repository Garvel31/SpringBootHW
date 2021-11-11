package ru.pobeda.springboothw.service;

import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Gear;

import java.util.List;

public interface GearService {
    Gear addGear(int size);

    Gear findGear(Car car);
    List<Gear> findGears(Car car);
}
