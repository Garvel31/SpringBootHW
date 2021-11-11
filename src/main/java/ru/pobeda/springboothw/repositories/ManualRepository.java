package ru.pobeda.springboothw.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.pobeda.springboothw.entities.Gear;
import ru.pobeda.springboothw.entities.Manual;

import java.util.List;

public interface ManualRepository extends CrudRepository<Manual, Long> {
    List<Manual> findAll();
    List<Manual> findManualById(Long id);
}
