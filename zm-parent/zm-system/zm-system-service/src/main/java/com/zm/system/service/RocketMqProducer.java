package com.zm.system.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/17 12:10
 */
public interface RocketMqProducer {

    /**
     * output代表的就是我们配置文件中定义的一个topic
     *
     * @return
     */
    @Output("output")
    MessageChannel output();     // SpringCloud stream定义的标准  生产者要发送给哪个topic

}
