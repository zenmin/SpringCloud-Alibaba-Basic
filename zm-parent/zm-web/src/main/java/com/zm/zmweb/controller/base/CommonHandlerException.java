package com.zm.zmweb.controller.base;

import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.ResponseEntity;
import com.zm.zmcommon.common.constant.DefinedCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Describle This Class Is 全局异常处理器
 * @Author ZengMin
 * @Date 2019/1/3 19:43
 */
@RestControllerAdvice
@Slf4j
public class CommonHandlerException extends RuntimeException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handler(RuntimeException e, HttpServletRequest request) {
        if (e instanceof CommonException) {
            return ResponseEntity.error(((CommonException) e).getCode(), e.getMessage());
        }
        e.printStackTrace();
        return ResponseEntity.error(DefinedCode.ERROR, "系统出错，请稍后再试！");
    }


}
