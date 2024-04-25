package com.example.springmvc_objectmapper.service;

import com.example.springmvc_objectmapper.dto.OrderDto;
import com.example.springmvc_objectmapper.entity.Order;
import com.example.springmvc_objectmapper.mapper.OrderMapper;
import com.example.springmvc_objectmapper.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto create(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        return orderMapper.toDto(order);
    }
}