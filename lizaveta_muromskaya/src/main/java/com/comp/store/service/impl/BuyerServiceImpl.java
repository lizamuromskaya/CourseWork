package com.comp.store.service.impl;

import com.comp.store.dto.ActDto;
import com.comp.store.dto.BuyerDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;
import com.comp.store.model.Act;
import com.comp.store.model.Buyer;
import com.comp.store.repository.ActRepository;
import com.comp.store.repository.BuyerRepository;
import com.comp.store.service.BuyerService;
import com.comp.store.service.converter.UserConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class BuyerServiceImpl implements BuyerService {
    private static final Logger logger = Logger.getLogger(String.valueOf(BuyerServiceImpl.class));


    private BuyerRepository buyerRepository;
    private UserConverter userConverter;

    public BuyerServiceImpl(BuyerRepository buyerRepository, UserConverter userConverter) {
        this.buyerRepository = buyerRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<BuyerDto> allBuyers() {
        logger.info("Show buyers");
        return StreamSupport.stream(buyerRepository
        .findAll().spliterator(), false)
                .map(buyer -> userConverter.convertToBuyerInfoDto(buyer))
                .sorted(Comparator.comparing(BuyerDto::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void add(BuyerDto dto) throws ConvertingException {
        logger.info("Add buyer id = " + dto.getId());
        Buyer buyer = userConverter.convertToBuyer(dto);
        buyerRepository.save(buyer);
    }

    @Transactional
    @Override
    public void delete(BuyerDto dto) throws ConvertingException {
            logger.info("Delete buyer id = " + dto.getId());
            Buyer buyer = userConverter.convertToBuyer(dto);
            buyerRepository.delete(buyer);
    }

    @Transactional
    @Override
    public void edit(BuyerDto dto) throws ConvertingException {
        logger.info("Edit buyer id = " + dto.getId());
        Buyer buyer = userConverter.convertToBuyer(dto);
        buyerRepository.save(buyer);
    }

    @Override
    public BuyerDto getById(Long id) throws NoSuchEntityException {
        logger.info("Get buyer by id = " + id);
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() -> new NoSuchEntityException(String.format("Can't find entity by id = %id", id)));
        return userConverter.convertToBuyerInfoDto(buyer);
    }

    @Override
    public List<BuyerDto> getBuyersByParam(String param) {
        logger.info("Get buyer by param: " + param);
        return StreamSupport.stream(buyerRepository
                .findAll().spliterator(), false)
                .map(buyer -> userConverter.convertToBuyerInfoDto(buyer))
                .filter(buyer -> buyer.getFirstName().contains(param)
                || buyer.getLastName().contains(param)
                || buyer.getPatronymicName().contains(param)
                || buyer.getUserName().contains(param)
                || buyer.getUserPassword().contains(param)
                || buyer.getRoleName().contains(param)
                || buyer.getEmail().contains(param)
                || buyer.getPhone().contains(param))
                .collect(Collectors.toList());
    }


}
