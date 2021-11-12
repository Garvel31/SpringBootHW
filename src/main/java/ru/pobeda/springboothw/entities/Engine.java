package ru.pobeda.springboothw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CAR_ID", referencedColumnName = "ID")
    private Car car;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")
    private List<Gear> gears;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Manual> manuals;

    public Engine(String engineType) {
        this.type = engineType;
        this.gears = new LinkedList<>();
        this.manuals = new LinkedList<>();
    }

    public String toString() {
        return type;
    }

//    @PreRemove
//    public void preRemove() {
//       Engine newEngine = new Engine("");
//       //car.setEngine(newEngine);
//       this.car.setEngine(newEngine);
//    }



}