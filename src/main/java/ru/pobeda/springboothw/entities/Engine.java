package ru.pobeda.springboothw.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.LinkedList;

@Entity
@Data
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    public Engine(String engineType) {
        this.type = engineType;

    }

    public String toString() {
        return type;
    }

}