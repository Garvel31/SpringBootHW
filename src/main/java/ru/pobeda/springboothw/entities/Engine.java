package ru.pobeda.springboothw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.pobeda.springboothw.repositories.CarRepository;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Engine {


    @Id
    @GeneratedValue
    private Long id;


    private String type;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")
    private List<Gear> gears;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Manual> manual;


    public Engine(String engineType) {
        this.type = engineType;
        this.gears = new LinkedList<>();
        this.manual = new LinkedList<>();
    }

    public String toString() {
        return type;
    }


}