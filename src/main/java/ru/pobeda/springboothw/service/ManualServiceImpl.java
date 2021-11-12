package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.entities.Manual;
import ru.pobeda.springboothw.entities.SteeringWheel;
import ru.pobeda.springboothw.repositories.EngineRepository;
import ru.pobeda.springboothw.repositories.ManualRepository;

import java.util.ArrayList;
import java.util.List;

public class ManualServiceImpl implements ManualService {

    @Autowired
    ManualRepository manualRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Manual addManual(String type) {
        final Manual newManual = new Manual(type);

        return manualRepository.save(newManual);
    }

    @Transactional
    public void deleteManual(Long id){
        Long engineId = engineRepository.findEngineByManualId(id).getId();
        engineRepository.findEngineByIdAndManualId(engineId, id).setManual(null);
        manualRepository.deleteManualByEnginesId(engineId);
        manualRepository.deleteById(id);

    }
}
