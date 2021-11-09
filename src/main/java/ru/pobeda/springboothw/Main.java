package ru.pobeda.springboothw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pobeda.springboothw.repositories.CarRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        CarRepository carRepository = applicationContext.getBean(CarRepository.class);
    }
}
