package com.comp.store.service.converter;

import com.comp.store.dto.ProductDto;
import com.comp.store.dto.ProductNameDto;
import com.comp.store.exception.ConvertingException;
import com.comp.store.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {

    public ProductNameDto convertToProductNameDto(Product product){
        ProductNameDto dto = new ProductNameDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        return dto;
    }

    public ProductDto convertToAllProductInfoDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setProductCost(product.getProductCost());
        return dto;
    }

    public Product convertToProduct(ProductDto dto){
        throwExceptionIfDtoIsNotValid(dto);

        Product product = new Product();
        product.setId(dto.getId());
        product.setProductName(dto.getProductName());
        product.setProductCost(dto.getProductCost());

        return product;
    }

    private void throwExceptionIfDtoIsNotValid(ProductDto dto) throws ConvertingException {
        if(dto == null){
            throw new ConvertingException("Product information must be not null.");
        }
        if(dto.getProductName() == null){
            throw new ConvertingException("Name must be not empty.");
        }
    }
}
