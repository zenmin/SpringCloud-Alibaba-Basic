package com.zm.goods.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zm.goods.bean.ItemsQo;
import com.zm.goods.service.OpenGoods;
import com.zm.goods.service.ItemsService;
import com.zm.zmcommon.common.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


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


}