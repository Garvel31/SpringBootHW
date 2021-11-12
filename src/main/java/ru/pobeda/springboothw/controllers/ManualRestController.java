package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.Manual;
import ru.pobeda.springboothw.entities.SteeringWheel;
import ru.pobeda.springboothw.repositories.ManualRepository;
import ru.pobeda.springboothw.repositories.SteeringWheelRepository;
import ru.pobeda.springboothw.service.ManualService;
import ru.pobeda.springboothw.service.ManualServiceImpl;

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/manual", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ManualRestController {

    @Autowired
    ManualRepository manualRepository;

    @Autowired
    ManualServiceImpl manualService;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(manualRepository.findAll())
                : Collections.singletonList(manualRepository.findManualById(id));
    }


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addEngine(@RequestBody(required = false) Manual body) {

        if (body != null && body.getType() != null && !body.getType().isEmpty())
            return manualRepository.save(body);
        else
            return "переданы не верные данные по объекту Manual";
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateEngine(@RequestParam(required = true) Long id, @RequestBody(required = false) Manual body) {
        List<Manual> newManual= manualRepository.findManualById(id);
        newManual.get(0).setType(body.getType());
        return manualRepository.save(newManual.get(0));
    }


    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Long id) {
        manualService.deleteManual(id);

    }


}