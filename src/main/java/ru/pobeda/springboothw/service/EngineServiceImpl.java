package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.repositories.CarRepository;
import ru.pobeda.springboothw.repositories.EngineRepository;

public class EngineServiceImpl implements EngineService{

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine addEngine(String type) {
        final Engine newEngine = new Engine(type);

        return engineRepository.save(newEngine);
    }
}
