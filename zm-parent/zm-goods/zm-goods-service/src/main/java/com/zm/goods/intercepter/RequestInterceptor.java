package com.zm.goods.intercepter;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Describle This Class Is 验证所有请求权限
 * @Author ZengMin
 * @Date 2019/1/3 19:18
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws JsonProcessingException {
        log.info("header1: ", request.getHeader("Seata-Xid"));
        return true;
    }

}
