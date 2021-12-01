package com.comp.store.service.converter;

import com.comp.store.dto.ActDto;
import com.comp.store.dto.ActViewDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.model.Act;
import com.comp.store.model.Buyer;
import com.comp.store.model.Product;
import com.comp.store.model.Seller;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ActConverter {

    public ActDto convertToAllActInfoDto(Act act){
        ActDto dto = new ActDto();
        dto.setId(act.getId());
        dto.setBuyerId(act.getBuyer().getId());
        dto.setSellerId(act.getSeller().getId());
        dto.setProductId(act.getProduct().getId());
        dto.setCount(act.getCount());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String date = dateFormat.format(act.getDate());
        dto.setDate(date);
        return dto;
    }

    public ActViewDto convertToAllActViewDto(Act act){
        ActViewDto dto = new ActViewDto();
        dto.setId(act.getId());
        dto.setBuyerName(act.getBuyer().getFirstName() + ' ' + act.getBuyer().getLastName());
        dto.setSellerName(act.getSeller().getFirstName() + ' ' + act.getSeller().getLastName());
        dto.setProductName(act.getProduct().getProductName());
        dto.setCount(act.getCount());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String date = dateFormat.format(act.getDate());
        dto.setDate(date);
        return dto;
    }

    public Act convertToAct(ActDto dto) throws ConvertingException, ParseException {
        throwExceptionIfDtoIsNotValid(dto);

        Act act = new Act();
        act.setId(dto.getId());
        Buyer buyer = new Buyer();
        buyer.setId(dto.getBuyerId());
        Seller seller = new Seller();
        seller.setId(dto.getSellerId());
        Product product = new Product();
        product.setId(dto.getProductId());
        act.setBuyer(buyer);
        act.setSeller(seller);
        act.setProduct(product);
        act.setCount(dto.getCount());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = simpleDateFormat.parse(dto.getDate());
        act.setDate(date);
        return act;
    }

    private void throwExceptionIfDtoIsNotValid(ActDto dto) {
        if(dto == null){
            throw new ConvertingException("Act must be not empty.");
        }
    }

}
