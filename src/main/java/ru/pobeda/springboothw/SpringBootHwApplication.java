package ru.pobeda.springboothw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.pobeda.springboothw.entities.Car;
import ru.pobeda.springboothw.repositories.CarRepository;
import ru.pobeda.springboothw.service.CarService;
import ru.pobeda.springboothw.service.CarServiceImpl;

//import ru.pobeda.springboothw.service.CarServiceImpl;

@SpringBootApplication
public class SpringBootHwApplication {

    public static void main(String[] args) {



        SpringApplication.run(SpringBootHwApplication.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        final CarService carServiceImpl = applicationContext.getBean(CarService.class);


       // final Car havalCar = carServiceImpl.addCar("Haval", "F7x");

        //CarRepository carRepository = applicationContext.getBean(CarRepository.class);
//        carRepository.save(new Car("Mazda", "3" ));
//        carRepository.save(new Car("Porsche", "Panamera" ));
        // List<Car> ford = carRepository.findCarByMnfName("Ford");
    }

}
