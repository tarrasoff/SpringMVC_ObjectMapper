package com.example.springmvc_objectmapper.service;

import com.example.springmvc_objectmapper.dto.ProductDto;
import com.example.springmvc_objectmapper.entity.Order;
import com.example.springmvc_objectmapper.entity.Product;
import com.example.springmvc_objectmapper.mapper.ProductMapper;
import com.example.springmvc_objectmapper.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        return productMapper.toDto(product);
    }

    public ProductDto create(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantityInStock(productDto.getQuantityInStock());
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        productRepository.delete(product);
    }
}