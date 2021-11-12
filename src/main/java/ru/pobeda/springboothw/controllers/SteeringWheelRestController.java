package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.SteeringWheel;
import ru.pobeda.springboothw.repositories.SteeringWheelRepository;
import ru.pobeda.springboothw.service.SteeringWheelServiceImpl;

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/stwheel", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SteeringWheelRestController {

    @Autowired
    SteeringWheelRepository steeringWheelRepository;

    @Autowired
    SteeringWheelServiceImpl steeringWheelService;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(steeringWheelRepository.findAll())
                : Collections.singletonList(steeringWheelRepository.findSteeringWheelById(id));
    }


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addEngine(@RequestBody(required = false) SteeringWheel body) {

        if (body != null && body.getType() != null && !body.getType().isEmpty())
            return steeringWheelRepository.save(body);
        else
            return "переданы не верные данные по объекту SteeringWheel";
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateEngine(@RequestParam(required = true) Long id, @RequestBody(required = false) SteeringWheel body) {
        List<SteeringWheel> newSteeringWheel= steeringWheelRepository.findSteeringWheelById(id);
        newSteeringWheel.get(0).setType(body.getType());
        return steeringWheelRepository.save(newSteeringWheel.get(0));
    }


    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Long id) {
        steeringWheelService.deleteSTWheel(id);
    }


}