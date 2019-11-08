package com.zm.zmweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Describle This Class Is 只用来做接口测试
 * @Author ZengMin
 * @Date 2019/11/7 11:56
 */
@Controller
@ApiIgnore
public class PortalController {

    @GetMapping("/")
    public String toIndex() {
        return "redirect:swagger-ui.html";
    }

}
