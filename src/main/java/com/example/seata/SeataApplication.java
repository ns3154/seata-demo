package com.example.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataApplication.class, args);
    }

}
