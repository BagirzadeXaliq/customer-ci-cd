package com.example.mscustomercicd.service;

import com.example.mscustomercicd.dao.entity.CustomerEntity;
import com.example.mscustomercicd.dao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    private final RabbitTemplate rabbitTemplate;

    @Cacheable(value = "customers", key = "#id")
    public CustomerEntity getCustomer(Long id) {
        System.out.println("DB-dən oxundu: " + id);
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @CachePut(value = "customers", key = "#customer.id")
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        rabbitTemplate.convertAndSend("customer.exchange", "customer.routing", customer);
        return customer;
    }

    @CacheEvict(value = "customers", key = "#id")
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

}