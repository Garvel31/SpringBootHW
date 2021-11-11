package ru.pobeda.springboothw.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pobeda.springboothw.entities.Manual;
import ru.pobeda.springboothw.entities.SteeringWheel;
import ru.pobeda.springboothw.repositories.ManualRepository;

public class ManualServiceImpl implements ManualService {

    @Autowired
    ManualRepository manualRepository;

    @Override
    public Manual addManual(String type) {
        final Manual newManual = new Manual(type);

        return manualRepository.save(newManual);
    }
}
