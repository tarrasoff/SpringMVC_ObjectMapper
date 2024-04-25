package com.example.springmvc_objectmapper.mapper;

import com.example.springmvc_objectmapper.dto.OrderDto;
import com.example.springmvc_objectmapper.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}