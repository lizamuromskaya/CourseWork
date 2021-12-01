package com.comp.store.repository;

import com.comp.store.dto.ProductDto;
import com.comp.store.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<ProductDto> getByProductName(String productName);
}
