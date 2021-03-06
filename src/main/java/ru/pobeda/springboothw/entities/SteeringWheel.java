package ru.pobeda.springboothw.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteeringWheel {

    @Id
    @GeneratedValue
    private Long id;

    String type;

    public SteeringWheel(String type) {
        this.type = type;
    }
}
