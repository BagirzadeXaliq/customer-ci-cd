package com.example.mscustomercicd.service;

import com.example.mscustomercicd.dao.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendCustomer(CustomerEntity customer) {
        rabbitTemplate.convertAndSend("customer.exchange", "customer.routing", customer);
    }

}