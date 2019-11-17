package com.zm.zmgeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zm
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmGatewayApplication.class, args);
    }
}
