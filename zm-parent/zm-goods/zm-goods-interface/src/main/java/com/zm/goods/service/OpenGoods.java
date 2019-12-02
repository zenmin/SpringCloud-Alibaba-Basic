package com.zm.goods.service;

import com.zm.goods.bean.ItemsQo;
import com.zm.zmcommon.common.ResponseEntity;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 17:56
 */
public interface OpenGoods {

    String PREFIX = "/api/goods";

    @GetMapping(PREFIX + "/getOne")
    ResponseEntity getOne(@RequestParam(value = "id") Long id);

    @PostMapping(PREFIX + "/list")
    ResponseEntity list(@RequestBody ItemsQo itemsQo);

    @PostMapping(value = PREFIX + "/listByPage")
    ResponseEntity listByPage(@RequestBody ItemsQo itemsQo);

    @PostMapping(PREFIX + "/save")
    ResponseEntity saveOrUpdate(@RequestBody ItemsQo items);

    @PostMapping(PREFIX + "/delete")
    ResponseEntity delete(@RequestParam(value = "ids") String ids);

    @PostMapping(PREFIX + "/checkStock")
    ResponseEntity checkStock(@RequestParam(value = "id") Long id, @RequestParam(value = "num") Integer num);

    @PostMapping(PREFIX + "/decrStock")
    @GlobalTransactional(timeoutMills = 3000, name = "SUBMIT_ORDER")
    ResponseEntity decrStock(@RequestParam(value = "id") Long id, @RequestParam(value = "num") Integer num);


}
