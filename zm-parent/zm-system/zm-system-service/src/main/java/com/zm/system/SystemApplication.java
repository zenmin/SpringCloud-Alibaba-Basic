package com.zm.system;

import com.zm.system.service.RocketMqProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.zm.*")
@EnableBinding({RocketMqProducer.class})     // 标识需要发送哪些output  注意  此处使用最新版springboot2.2 启动会报错  非常坑
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }


}
