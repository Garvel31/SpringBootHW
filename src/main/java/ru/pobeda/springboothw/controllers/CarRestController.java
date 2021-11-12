package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.repositories.CarRepository;
import ru.pobeda.springboothw.service.CarServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    @Autowired
    CarServiceImpl carService;

    @Autowired
    CarRepository carRepository;

    @PostConstruct
    private void postConstruct() {
        carService.addCar("BMV", "3", "petrol");
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(carRepository.findAll())
                : Collections.singletonList(carRepository.findCarById(id));
    }


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addCar(@RequestBody(required = false) Car body) {

        if (body != null && body.getMnfName() != null && !body.getMnfName().isEmpty()
                && body.getModelName() != null && !body.getModelName().isEmpty())
            return carRepository.save(body);
        else
            return "переданы не верные данные по объекту Car";
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCar(@RequestParam(required = true) Long id, @RequestBody(required = false) Car body) {
        List<Car> newCar = carRepository.findCarById(id);
        newCar.get(0).setMnfName(body.getMnfName());
        newCar.get(0).setModelName(body.getModelName());
        newCar.get(0).setEngine(body.getEngine());
        return carRepository.save(newCar.get(0));
    }


    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCar(@RequestParam(required = true) Long id) {
        carRepository.deleteById(id);
    }


}

