package com.example.mscustomercicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MsCustomerCiCdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerCiCdApplication.class, args);
    }

}
