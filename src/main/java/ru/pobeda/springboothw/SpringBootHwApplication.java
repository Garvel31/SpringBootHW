package ru.pobeda.springboothw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pobeda.springboothw.entity.Car;
import ru.pobeda.springboothw.repositories.CarRepository;

import java.util.List;

@SpringBootApplication
public class SpringBootHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHwApplication.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        CarRepository carRepository = applicationContext.getBean(CarRepository.class);
       // carRepository.save(new Car("Ford", "Focus" ));
       // List<Car> ford = carRepository.findCarByMnfName("Ford");

    }

}
