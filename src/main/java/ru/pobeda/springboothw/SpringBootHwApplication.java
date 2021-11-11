package ru.pobeda.springboothw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import ru.pobeda.springboothw.service.CarServiceImpl;

@SpringBootApplication
public class SpringBootHwApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringBootHwApplication.class, args);

        //final CarService carServiceImpl = applicationContext.getBean(CarService.class);
        // final Car havalCar = carServiceImpl.addCar("Haval", "F7x", "petrol");


    }

}
