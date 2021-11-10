package ru.pobeda.springboothw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.repositories.CarRepository;

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    @Autowired
    CarRepository carRepository;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(carRepository.findAll())
                : Collections.singletonList(carRepository.findCarById(id));
    }

    //--------------КАК СДЕЛАТЬ ОБРАБОТКУ ОШИБКИ ЕСЛИ ПЕРЕДАНЫ НЕ ПРАВИЛЬНЫЕ ДАННЫЕ (НЕ В ФОРМАТЕ JASON)??
    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addCar(@RequestBody(required = false) Car body) {

//---------ПЕРЕДЕЛАТЬ В МЕТОД UPDATE
        Long id = 1L;
        List<Car> newCar = carRepository.findCarById(id);

        newCar.get(0).setMnfName(body.getMnfName());
        newCar.get(0).setModelName(body.getModelName());
        carRepository.save(newCar.get(0));


//        try {
        if (body != null && body.getMnfName() != null && !body.getMnfName().isEmpty()
                && body.getModelName() != null && !body.getModelName().isEmpty())
            return carRepository.save(body);
        else
            return "переданы не верные данные по объекту Car";
//        } catch (Exception ex) {
//            return "переданы не верные данные по объекту Car";
//        }

    }

    //-------------UPDATE - АПДЕЙТИМ ВСЕ ПОЛЯ ИЛИ ЛЮБЫЕ КОТОРЫЕ ПРИДУТ?
}

