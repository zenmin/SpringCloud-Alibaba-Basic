package com.zm.zmweb;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zm
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zm.*")
@ComponentScan("com.zm.*")    /**  必须添加 不然无法扫描到其他包下的Hystrix的factory  比如我此处是com.zm.zmweb  那么我引入com.zm.goods 下面的bean是无法扫描到的 */
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
