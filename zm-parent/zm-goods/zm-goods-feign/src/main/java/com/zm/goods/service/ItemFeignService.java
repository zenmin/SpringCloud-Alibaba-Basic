package com.zm.goods.service;

import com.zm.goods.callback.ItemFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 22:09
 */
@FeignClient(value = "ZM-GATEWAY", fallbackFactory = ItemFallBackFactory.class)
public interface ItemFeignService extends OpenGoods {
}
