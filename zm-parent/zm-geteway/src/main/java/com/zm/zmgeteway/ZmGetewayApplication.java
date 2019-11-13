package com.zm.zmgeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZmGetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmGetewayApplication.class, args);
    }
}
