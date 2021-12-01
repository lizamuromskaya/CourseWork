package com.comp.store.repository;

import com.comp.store.model.Act;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActRepository extends CrudRepository<Act, Long> {

}
