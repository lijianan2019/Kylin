package com.lijianan.kylin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class KylinApplication {

    public static void main(String[] args) {
        SpringApplication.run(KylinApplication.class, args);
    }

}
