package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Engine;
import ru.pobeda.springboothw.entities.Gear;

import java.util.List;
import java.util.Optional;

public interface EngineRepository extends CrudRepository<Engine, Long> {
    Engine findEngineByIdAndManualId(Long id, Long manualId);
    Engine findEngineByManualId(Long id);
    List<Engine> findAll();
    List<Engine> findEngineById(Long id);
//    Engine findEngineByCarId(Long carId);
}
