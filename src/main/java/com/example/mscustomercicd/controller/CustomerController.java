package com.example.mscustomercicd.controller;

import com.example.mscustomercicd.dao.entity.CustomerEntity;
import com.example.mscustomercicd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/{id}")
    public CustomerEntity getCustomer(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity customer) {
        customer.setId(id);
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Deleted";
    }

}