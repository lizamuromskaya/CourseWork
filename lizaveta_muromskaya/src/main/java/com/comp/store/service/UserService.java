package com.comp.store.service;

import com.comp.store.dto.GeneralUserDto;
import com.comp.store.dto.UserDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.util.List;

public interface UserService {

    List<UserDto> allUsers();

    List<GeneralUserDto> allUserGeneralInfo();

    void add(UserDto dto) throws Exception;

    UserDto getByUserName(String username) throws ConvertingException;

    void edit(UserDto dto) throws ConvertingException;

    UserDto getById(Long id) throws NoSuchEntityException;
}
