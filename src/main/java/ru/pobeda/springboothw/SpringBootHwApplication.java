package ru.pobeda.springboothw;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.service.CarService;
import ru.pobeda.springboothw.service.CarServiceImpl;


import ru.pobeda.springboothw.service.CarServiceImpl;

@SpringBootApplication
public class SpringBootHwApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringBootHwApplication.class, args);

    }

}
