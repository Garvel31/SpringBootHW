package ru.pobeda.springboothw.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manual {

    @Id
    @GeneratedValue
    private Long id;

    String type;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "manuals")
    @JsonIgnore
    List<Engine> engines;

    public Manual(String type) {
        this.type  = type;
        this.engines = new LinkedList<>();

    }
}