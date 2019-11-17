package com.zm.goods.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Describle This Class Is 表示需要监听本topic下的那些消息
 * @Author ZengMin
 * @Date 2019/11/17 13:50
 */
public interface MQListenerInput {

    /**
     * input代表的就是我们配置文件中定义的一个topic
     *
     * @return
     */
    @Input("input")
    SubscribableChannel input();        // SpringCloud stream定义的标准  订阅者要监听哪个topic

}
