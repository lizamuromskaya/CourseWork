package com.comp.store.service;

import com.comp.store.dto.GeneralUserDto;
import com.comp.store.dto.SellerDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.util.List;

public interface SellerService {

    List<SellerDto> allSellers();

    void add(SellerDto dto) throws ConvertingException;

    void delete(SellerDto dto) throws ConvertingException;

    void edit(SellerDto dto) throws ConvertingException;

    SellerDto getById(Long id) throws NoSuchEntityException;

    List<SellerDto> getSellersByParam(String param);

    List<GeneralUserDto> getGeneralSellersInfo();

    List<GeneralUserDto> getSellersGeneralInfoByParam(String param);
}
