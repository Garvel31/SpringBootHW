package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Engine;
import java.util.List;
import java.util.Optional;

public interface EngineRepository extends CrudRepository<Engine, Long> {

    List<Engine> findAll();
    Optional<Engine> findById(Long id);

}
