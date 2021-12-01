package com.comp.store.service.converter;

import com.comp.store.dto.BuyerDto;
import com.comp.store.dto.GeneralUserDto;
import com.comp.store.dto.SellerDto;
import com.comp.store.dto.UserDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.model.*;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public GeneralUserDto convertToGeneralUserInfoDto(AbstractUser user){
        GeneralUserDto dto = new GeneralUserDto();
        dto.setId(user.getId());
        dto.setRoleName(user.getUserRole().getValue());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserName(user.getUserName());
        return dto;
    }

    public UserDto convertToAllUserInfoDto(AbstractUser user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setRoleName(user.getUserRole().getValue());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPatronymicName(user.getPatronymicName());
        dto.setUserName(user.getUserName());
        dto.setUserPassword(user.getUserPassword());
        return dto;
    }

    public AbstractUser convertToUser(UserDto dto){
        AbstractUser user = new AbstractUser();
        user = getBaseUser(user, dto);
        return user;
    }


    public Buyer convertToBuyer(BuyerDto dto) throws ConvertingException{
        throwExceptionIfDtoIsNotValid(dto);

        Buyer buyer = new Buyer();
        buyer = (Buyer)getBaseUser(buyer, dto);
        buyer.setEmail(dto.getEmail());
        buyer.setPhone(dto.getPhone());
        return buyer;
    }

    public BuyerDto convertToBuyerInfoDto(Buyer buyer){
        BuyerDto dto = new BuyerDto();
        dto.setId(buyer.getId());
        dto.setEmail(buyer.getEmail());
        dto.setRoleName(buyer.getUserRole().getValue());
        dto.setPhone(buyer.getPhone());
        dto.setFirstName(buyer.getFirstName());
        dto.setLastName(buyer.getLastName());
        dto.setPatronymicName(buyer.getPatronymicName());
        dto.setUserName(buyer.getUserName());
        dto.setUserPassword(buyer.getUserPassword());
        return dto;
    }

    public Seller convertToSeller(SellerDto dto) throws ConvertingException{
        throwExceptionIfDtoIsNotValid(dto);

        Seller seller = new Seller();
        seller = (Seller)getBaseUser(seller, dto);
        Position position = new Position();
        position.setId(dto.getPositionId());
        seller.setPosition(position);
        return seller;
    }

    public SellerDto convertToSellerInfoDto(Seller seller){
        SellerDto dto = new SellerDto();
        dto.setId(seller.getId());
        dto.setRoleName(seller.getUserRole().getValue());
        dto.setFirstName(seller.getFirstName());
        dto.setLastName(seller.getLastName());
        dto.setPatronymicName(seller.getPatronymicName());
        dto.setUserName(seller.getUserName());
        dto.setUserPassword(seller.getUserPassword());
        dto.setPositionId(seller.getPosition().getId());
        return dto;
    }

    private AbstractUser getBaseUser(AbstractUser user, UserDto dto){
        user.setId(dto.getId());
        user.setUserRole(RoleEnum.valueOf(dto.getRoleName()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPatronymicName(dto.getPatronymicName());
        user.setUserName(dto.getUserName());
        user.setUserPassword(dto.getUserPassword());
        return user;
    }

    private void throwExceptionIfDtoIsNotValid(UserDto dto) throws ConvertingException {
        if (dto == null)
            throw new ConvertingException("Must be not null.");
        if (dto.getRoleName() == null)
            throw new ConvertingException("Role must be not null.");
        if (dto.getFirstName() == null || dto.getLastName() == null || dto.getPatronymicName() == null)
            throw new ConvertingException("Name must be not null.");

        if (dto instanceof SellerDto) {
            if (((SellerDto) dto).getPositionId() == null)
                throw new ConvertingException(("Position must be not null"));
        }
    }

}
