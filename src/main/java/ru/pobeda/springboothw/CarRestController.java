package ru.pobeda.springboothw;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pobeda.springboothw.JavaConfig;
import ru.pobeda.springboothw.repositories.CarRepository;

import java.util.Collections;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

        @Autowired
        CarRepository carRepository;

//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
//    CarRepository carRepository = applicationContext.getBean(CarRepository.class);

    @GetMapping(value = "show", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        return id == null
                ? Collections.unmodifiableList(carRepository.findAll())
                : Collections.singletonList(carRepository.findCarById(id));
    }
}

