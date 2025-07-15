package com.example.mscustomercicd.service;

import com.example.mscustomercicd.dao.entity.CustomerEntity;
import com.example.mscustomercicd.dao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerConsumer {

    private final CustomerRepository repository;

    @RabbitListener(queues = "customer.queue")
    public void listen(CustomerEntity customer) {
        repository.save(customer);
    }

}