package com.zm.goods.callback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Describle This Class Is 服务降级处理类
 * @Author ZengMin
 * @Date 2019/11/13 20:16
 */
@Component
public class ItemFallBackFactory implements FallbackFactory<ItemFallBack> {

    @Override
    public ItemFallBack create(Throwable throwable) {
        return new ItemFallBack(throwable);
    }
}
