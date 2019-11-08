package com.zm.goods.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 22:09
 */
@FeignClient("ZM-GOODS")
public interface ItemFeignService extends OpenGoods {
}
