package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.repositories.CarRepository;
import ru.pobeda.springboothw.repositories.EngineRepository;

import javax.persistence.PreRemove;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/engine", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class EngineRestController {

    @Autowired
    EngineRepository engineRepository;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(engineRepository.findAll())
                : Collections.singletonList(engineRepository.findEngineById(id));
    }


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addEngine(@RequestBody(required = false) Engine body) {

        if (body != null && body.getType() != null && !body.getType().isEmpty())
            return engineRepository.save(body);
        else
            return "переданы не верные данные по объекту Engine";
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateEngine(@RequestParam(required = true) Long id, @RequestBody(required = false) Engine body) {
        List<Engine> newEngine = engineRepository.findEngineById(id);
        newEngine.get(0).setType(body.getType());
        return engineRepository.save(newEngine.get(0));
    }


    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Long id) {
        engineRepository.deleteById(id);
    }


}

