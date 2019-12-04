package com.zm.system.callback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Describle This Class Is 服务降级处理类
 * @Author ZengMin
 * @Date 2019/11/13 20:16
 */
@Component
public class SystemFallBackFactory implements FallbackFactory<SystemFallBack> {
    @Override
    public SystemFallBack create(Throwable throwable) {
        return new SystemFallBack(throwable);
    }
}
