package com.zm.system.service;


import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 20:38
 */
@FeignClient("ZM-SYSTEM")
public interface UserFeignService extends OpenSystem {
}
