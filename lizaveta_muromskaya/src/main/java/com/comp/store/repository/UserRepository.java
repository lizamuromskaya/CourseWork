package com.comp.store.repository;

import com.comp.store.dto.UserDto;
import com.comp.store.model.AbstractUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AbstractUser, Long> {
    UserDto getByUserName(String login);
}
