package ru.pobeda.springboothw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private long id;


    private String mnfName;
    private String modelName;

    public Car(String mnfName, String modelName) {
        this.mnfName = mnfName;
        this.modelName = modelName;
    }
}
