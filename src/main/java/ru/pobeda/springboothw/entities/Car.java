package ru.pobeda.springboothw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String mnfName;
    private String modelName;

    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STEERINGWHEEL_ID")
    private SteeringWheel steeringWheel;

    public Car(String mnfName, String modelName) {
        this.mnfName = mnfName;
        this.modelName = modelName;
    }

    //    @PreRemove
//    public void preRemove() {
//       engine.setType(null);
//    }

}
