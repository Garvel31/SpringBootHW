package ru.pobeda.springboothw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gear {

    @Id
    @GeneratedValue
    private Long id;

    private int gearSize;

    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Engine engine;

    public Gear(int size) {
        this.gearSize = size;
    }

    public String toString() {
        return "Gear for engine " + engine.toString() + " with size " + getGearSize();
    }

}
