package com.zm.zmweb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zm.goods.bean.ItemsQo;
import com.zm.goods.service.ItemFeignService;
import com.zm.zmcommon.common.ResponseEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 11:02
 */
@RestController
@RequestMapping("/api/goods")
@Api(tags = "商品管理")
public class GoodsFeignController {

    public static final String GOODS_LIMIT_KEY = "GOODS-LISTBYPAGE";

    @Autowired
    ItemFeignService itemFeignService;

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping("/getOne")
    public ResponseEntity getOne(Long id) {
        return itemFeignService.getOne(id);
    }

    /**
     * 查询全部 可带条件
     *
     * @return
     */
    @PostMapping("/list")
    public ResponseEntity list(ItemsQo itemsQo) {
        return itemFeignService.list(itemsQo);
    }

    /**
     * 查全部 可带条件分页
     * <p>
     * Sentinel starter 默认为所有的 HTTP 服务提供了限流埋点，如果只想对 HTTP 服务进行限流，那么只需要引入依赖，无需修改代码。
     * 自定义埋点
     * 如果需要对某个特定的方法进行限流或降级，可以通过 @SentinelResource 注解来完成限流的埋点
     * https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
     *
     * @return
     */
    @PostMapping("/listByPage")
    @SentinelResource(value = GOODS_LIMIT_KEY, fallback = "qpsOverFallBack", blockHandler = "qpsBlockHandler")
    public ResponseEntity listByPage(ItemsQo itemsQo) {
        return itemFeignService.listByPage(itemsQo);
    }

    /**
     * 带ID更新 不带ID新增
     *
     * @param itemsQo
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity saveOrUpdate(ItemsQo itemsQo) {
        return itemFeignService.saveOrUpdate(itemsQo);
    }

    /**
     * 根据id删除   多个用,隔开
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity delete(String ids) {
        return itemFeignService.delete(ids);
    }

    /**
     * 限流fallback方法  参数要与原方法一致
     *
     * @param itemsQo
     * @return
     */
    public ResponseEntity qpsOverFallBack(ItemsQo itemsQo) {
        return ResponseEntity.error("失败，请稍后再试");
    }

    public ResponseEntity qpsBlockHandler(ItemsQo itemsQo, BlockException e) {
        e.printStackTrace();
        return ResponseEntity.error("请求频繁，请稍后再试");
    }


}
