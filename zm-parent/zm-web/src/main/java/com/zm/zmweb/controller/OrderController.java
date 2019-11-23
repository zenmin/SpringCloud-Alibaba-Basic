package com.zm.zmweb.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.zm.goods.service.ItemFeignService;
import com.zm.system.bean.UserQo;
import com.zm.system.service.UserFeignService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is 此处演示seata分布式事务
 * @Author ZengMin
 * @Date 2019/11/23 13:07
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    ItemFeignService itemFeignService;

    @Autowired
    UserFeignService userFeignService;


    @PostMapping("/submit")
    public ResponseEntity submitOrder(Long uid, Long orderId, Integer num) {
        // 模拟扣减库存
        ResponseEntity item = itemFeignService.decrStock(orderId, num);
        if (item.getCode() != 100) {
            throw new CommonException(item.getCode(), item.getMsg());
        }
        Double price = Double.valueOf(item.getData().toString());
        // 模拟扣减金额
        UserQo userQo = new UserQo();
        userQo.setId(uid);
        userQo.setAccount(price);
        ResponseEntity user = userFeignService.decrAccount(userQo);
        if (user.getCode() != 100) {
            throw new CommonException(user.getCode(), user.getMsg());
        }
        // 生成订单号
        String oid = IdWorker.getTimeId();
        // 创建订单 ...

        // ...

        return ResponseEntity.success(oid);
    }

}
