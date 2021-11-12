package ru.pobeda.springboothw;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import ru.pobeda.springboothw.service.CarServiceImpl;
import ru.pobeda.springboothw.service.EngineServiceImpl;
import ru.pobeda.springboothw.service.ManualServiceImpl;
import ru.pobeda.springboothw.service.SteeringWheelServiceImpl;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = "ru.pobeda.springboothw.repositories")
public class JavaConfig {

    @Value("${driver-class-name}")
    private String driverClassName;

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;

    @Value("${URL}")
    private String url;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.pobeda");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public CarServiceImpl carService() {
        return new CarServiceImpl() {
        };
    }

    @Bean
    public EngineServiceImpl engineService() {
        return new EngineServiceImpl() {
        };
    }

    @Bean
    public ManualServiceImpl manualService() {
        return new ManualServiceImpl() {
        };
    }

    @Bean
    public SteeringWheelServiceImpl steeringWheelService() {
        return new SteeringWheelServiceImpl() {
        };
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
