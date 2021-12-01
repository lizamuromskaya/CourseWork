package com.comp.store.service;

import com.comp.store.dto.ProductDto;
import com.comp.store.dto.ProductNameDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.NoSuchEntityException;

import java.util.List;

public interface ProductService {

    List<ProductDto> allProducts();

    List<ProductNameDto> allProductNames();

    void add(ProductDto dto) throws ConvertingException;

    void delete(ProductDto dto) throws ConvertingException;

    void edit(ProductDto dto) throws ConvertingException;

    ProductDto getById(Long id) throws NoSuchEntityException;

    List<ProductDto> getProductsByName(String productName);
}
