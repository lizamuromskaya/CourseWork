package com.comp.store.service;

import com.comp.store.dto.PositionDto;
import com.comp.store.dto.PositionNameDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.util.List;

public interface PositionService{

    List<PositionDto> allPositions();

    List<PositionNameDto> allPositionNames();

    void add(PositionDto dto) throws ConvertingException;

    void delete(PositionDto dto) throws ConvertingException;

    void edit(PositionDto dto) throws ConvertingException;

    PositionDto getById(Long id) throws NoSuchEntityException;

    List<PositionDto> getPositionsByName(String name);

    Long getCountBySalary(Long min, Long max);
}
