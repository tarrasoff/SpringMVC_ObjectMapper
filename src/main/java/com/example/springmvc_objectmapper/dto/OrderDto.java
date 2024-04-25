package com.example.springmvc_objectmapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private Long orderId;

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @NotNull(message = "Product IDs cannot be null")
    private List<Long> productIds;

    @NotNull(message = "Order date cannot be null")
    private Date orderDate;

    @NotBlank(message = "Shipping address is required")
    private String shippingAddress;

    @NotNull(message = "Total price cannot be null")
    @PositiveOrZero(message = "Total price must be positive or zero")
    private BigDecimal totalPrice;

    @NotBlank(message = "Order status is required")
    private String orderStatus;
}