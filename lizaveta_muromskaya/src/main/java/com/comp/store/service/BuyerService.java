package com.comp.store.service;

import com.comp.store.dto.BuyerDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.util.List;

public interface BuyerService {

    List<BuyerDto> allBuyers();

    void add(BuyerDto dto) throws ConvertingException;

    void delete(BuyerDto dto) throws ConvertingException;

    void edit(BuyerDto dto) throws ConvertingException;

    BuyerDto getById(Long id) throws NoSuchEntityException;

    List<BuyerDto> getBuyersByParam(String param);
}
