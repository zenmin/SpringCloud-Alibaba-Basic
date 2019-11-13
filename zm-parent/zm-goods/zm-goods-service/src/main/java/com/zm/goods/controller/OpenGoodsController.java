package com.zm.goods.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zm.goods.bean.ItemsQo;
import com.zm.goods.service.OpenGoods;
import com.zm.goods.service.ItemsService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.ResponseEntity;
import com.zm.zmcommon.common.constant.DefinedCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Create by Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 10:17:53
 */

@RestController
public class OpenGoodsController implements OpenGoods {

    public static final String GOODS_LIMIT_KEY = "GOODS-LISTBYPAGE";

    @Autowired
    ItemsService itemsService;

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity getOne(Long id) {
        return ResponseEntity.success(itemsService.getOne(id));
    }

    /**
     * 查询全部 可带条件
     *
     * @return
     */
    @Override
    public ResponseEntity list(ItemsQo itemsQo) {
        return ResponseEntity.success(itemsService.list(itemsQo));
    }

    /**
     * 查全部 可带条件分页
     * Sentinel starter 默认为所有的 HTTP 服务提供了限流埋点，如果只想对 HTTP 服务进行限流，那么只需要引入依赖，无需修改代码。
     * 自定义埋点
     * 如果需要对某个特定的方法进行限流或降级，可以通过 @SentinelResource 注解来完成限流的埋点
     * https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
     *
     *
     *
     * @return
     */
    @Override
    @SentinelResource(value = GOODS_LIMIT_KEY,fallback = "qpsOverFallBack")
    public ResponseEntity listByPage(ItemsQo itemsQo) {
        return ResponseEntity.success(itemsService.listByPage(itemsQo));
    }

    /**
     * 带ID更新 不带ID新增
     *
     * @return
     */
    @Override
    public ResponseEntity saveOrUpdate(ItemsQo itemsVo) {
        return ResponseEntity.success(itemsService.save(itemsVo));
    }

    /**
     * 根据id删除   多个用,隔开
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseEntity delete(String ids) {
        return ResponseEntity.success(itemsService.delete(ids));
    }

    /**
     * 限流fallback方法  参数要与原方法一致
     * @param itemsQo
     * @return
     */
    public ResponseEntity qpsOverFallBack(ItemsQo itemsQo) {
        return ResponseEntity.error("出错了，请稍后再试");
    }


}