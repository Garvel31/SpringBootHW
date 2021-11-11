package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.entities.Gear;
import ru.pobeda.springboothw.repositories.EngineRepository;
import ru.pobeda.springboothw.repositories.GearRepository;

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/gear", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class GearRestController {

    @Autowired
    GearRepository gearRepository;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(gearRepository.findAll())
                : Collections.singletonList(gearRepository.findGearById(id));
    }


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addEngine(@RequestBody(required = false) Gear body) {

        if (body != null)
            return gearRepository.save(body);
        else
            return "переданы не верные данные по объекту Gear";
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateEngine(@RequestParam(required = true) Long id, @RequestBody(required = false) Gear body) {
        List<Gear> newGear = gearRepository.findGearById(id);
        newGear.get(0).setGearSize(body.getGearSize());
        return gearRepository.save(newGear.get(0));
    }


    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Long id) {
        gearRepository.deleteById(id);
    }


}

