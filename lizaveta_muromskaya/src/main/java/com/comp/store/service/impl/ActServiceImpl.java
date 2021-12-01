package com.comp.store.service.impl;

import com.comp.store.dto.ActDto;
import com.comp.store.dto.ActViewDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;
import com.comp.store.model.Act;
import com.comp.store.repository.ActRepository;
import com.comp.store.service.ActService;
import com.comp.store.service.converter.ActConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class ActServiceImpl implements ActService {
    private static final Logger logger = Logger.getLogger(String.valueOf(ActServiceImpl.class));

    private ActRepository actRepository;
    private ActConverter actConverter;

    @Autowired
    public ActServiceImpl(ActRepository actRepository, ActConverter actConverter) {
        this.actRepository = actRepository;
        this.actConverter = actConverter;
    }

    @Override
    public List<ActDto> allActs() {
        logger.info("Show acts");
        return StreamSupport.stream(actRepository
        .findAll().spliterator(), false)
                .map(act -> actConverter.convertToAllActInfoDto(act))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActViewDto> allActsView() {
        logger.info("Show acts");
        return StreamSupport.stream(actRepository
                        .findAll().spliterator(), false)
                .map(act -> actConverter.convertToAllActViewDto(act))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void add(ActDto dto) throws ConvertingException, ParseException {
        logger.info("Act info = " + dto.getId() + dto.getProductId() + dto.getBuyerId());
        logger.info("Add act id = " + dto.getId());
        Act act = actConverter.convertToAct(dto);
        actRepository.save(act);
    }

    @Transactional
    @Override
    public void delete(ActDto dto) throws ConvertingException, ParseException {
        logger.info("Delete act id = " + dto.getId());
        Act act = actConverter.convertToAct(dto);
        actRepository.delete(act);
    }

    @Transactional
    @Override
    public void edit(ActDto dto) throws ConvertingException, ParseException {
        logger.info("Edit act id = " + dto.getId());
        logger.info("===============");
        logger.info("Product " + dto.getProductId());
        logger.info("Seller " + dto.getSellerId());
        logger.info("Buyer " + dto.getBuyerId());
        logger.info("Count " + dto.getCount());
        logger.info("===============");
        Act act = actConverter.convertToAct(dto);
        actRepository.save(act);
    }

    @Override
    public ActDto getById(Long id) throws NoSuchEntityException {
        logger.info("Get act by id = " + id);
        Act act = actRepository.findById(id).orElseThrow(() -> new NoSuchEntityException(String.format("Can't find entity by id = %id", id)));
        return actConverter.convertToAllActInfoDto(act);
    }

    @Override
    public ActViewDto getViewById(Long id) throws NoSuchEntityException {
        logger.info("Get act by id = " + id);
        Act act = actRepository.findById(id).orElseThrow(() -> new NoSuchEntityException(String.format("Can't find entity by id = %id", id)));
        return actConverter.convertToAllActViewDto(act);
    }

    @Override
    public List<ActViewDto> getActsByParam(String param) {
        logger.info("Act by param " + param);
        return StreamSupport.stream(actRepository
                .findAll().spliterator(), false)
                .map(act -> actConverter.convertToAllActViewDto(act))
                .filter(act -> act.getId().toString().contains(param)
                        || act.getProductName().contains(param)
                        || act.getBuyerName().contains(param)
                        || act.getSellerName().contains(param)
                        || act.getCount().toString().contains(param)
                        || act.getDate().contains(param))
                .collect(Collectors.toList());
    }
}
