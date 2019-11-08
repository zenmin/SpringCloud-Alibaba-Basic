package com.zm.zmweb.controller;

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
     *
     * @return
     */
    @PostMapping("/listByPage")
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


}
