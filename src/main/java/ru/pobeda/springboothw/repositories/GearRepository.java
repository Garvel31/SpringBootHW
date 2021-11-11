package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.entities.Gear;

import java.util.List;

public interface GearRepository extends CrudRepository<Gear, Long> {


    Gear findGearByEngineId(Long engineId);

    List<Gear> findGearsByEngineId(Long engineId);
    List<Gear> findAll();
    List<Gear> findGearById(Long id);
}