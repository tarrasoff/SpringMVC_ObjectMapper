package com.example.springmvc_objectmapper.mapper;

import com.example.springmvc_objectmapper.dto.ProductDto;
import com.example.springmvc_objectmapper.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
}