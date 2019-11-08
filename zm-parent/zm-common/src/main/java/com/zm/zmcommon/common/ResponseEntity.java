package com.zm.zmcommon.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zm.zmcommon.common.constant.DefinedCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Describle This Class Is 全局接口返回类
 * @Author ZengMin
 * @Date 2019/1/3 19:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ResponseEntity {

    private int code;

    private String msg;

    private Object data;

    public static ResponseEntity success() {
        return new ResponseEntity(DefinedCode.SUCCESS, "success", null);
    }

    public static ResponseEntity success(Object data) {
        return new ResponseEntity(DefinedCode.SUCCESS, "success", data);
    }

    public static ResponseEntity error(int code, String msg) {
        return new ResponseEntity(code, msg, null);
    }

    public static ResponseEntity error() {
        return new ResponseEntity(DefinedCode.ERROR, "失败", null);
    }

    public static ResponseEntity error(String msg) {
        return new ResponseEntity(DefinedCode.ERROR, msg, null);
    }


}
