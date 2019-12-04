package com.zm.goods.controller;

import com.zm.goods.bean.ItemsQo;
import com.zm.goods.entity.Items;
import com.zm.goods.service.OpenGoods;
import com.zm.goods.service.ItemsService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.ResponseEntity;
import com.zm.zmcommon.common.constant.DefinedCode;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


/**
 * Create by Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 10:17:53
 */

@RestController
public class OpenGoodsController implements OpenGoods {


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
     *
     * @return
     */
    @Override
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
     * 检查库存
     *
     * @param id
     * @param num
     * @return
     */
    @Override
    public ResponseEntity checkStock(Long id, Integer num) {
        Items one = itemsService.getOne(id);
        Integer stock = one.getStock();
        return ResponseEntity.success((stock > 0) && (stock > num));
    }

    @Override
    public ResponseEntity decrStock(Long id, Integer num) {
        System.out.println("xid:" + RootContext.getXID());
        Items one = itemsService.getOne(id);
        Integer stock = one.getStock();
        if ((stock <= 0) || (stock < num)) {
            throw new CommonException(DefinedCode.ERROR, "库存不足！");
        }
        ItemsQo itemsQo = new ItemsQo();
        itemsQo.setId(id);
        itemsQo.setStock(stock - num);
        itemsService.save(itemsQo);
        // 计算价格
        double p = new BigDecimal(one.getPrice()).multiply(new BigDecimal(num)).doubleValue();
        return ResponseEntity.success(p);
    }

}