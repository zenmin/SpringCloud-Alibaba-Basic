package com.zm.goods;

import com.zm.goods.service.MQListenerInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan("com.zm.*")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableBinding({MQListenerInput.class})     // 标识需要监听哪些input   注意  此处使用最新版springboot2.2 启动会报错  非常坑
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }


}
