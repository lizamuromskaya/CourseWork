package com.comp.store.service;

import com.comp.store.dto.ActDto;
import com.comp.store.dto.ActViewDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.text.ParseException;
import java.util.List;

public interface ActService {

    List<ActDto> allActs();

    List<ActViewDto> allActsView();

    void add(ActDto dto) throws ConvertingException, ParseException;

    void delete(ActDto dto) throws ConvertingException, ParseException;

    void edit(ActDto dto) throws ConvertingException, ParseException;

    ActDto getById(Long id) throws NoSuchEntityException;

    ActViewDto getViewById(Long id) throws NoSuchEntityException;

    List<ActViewDto> getActsByParam(String param);
}
