package com.example.mscustomercicd.dao.repository;

import com.example.mscustomercicd.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}