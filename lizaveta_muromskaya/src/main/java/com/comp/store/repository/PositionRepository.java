package com.comp.store.repository;

import com.comp.store.dto.PositionDto;
import com.comp.store.model.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Long> {
    List<PositionDto> getByName(String name);
}
