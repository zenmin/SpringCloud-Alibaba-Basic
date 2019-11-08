package com.zm.system.controller;

import com.zm.system.bean.UserQo;
import com.zm.system.service.OpenSystem;
import com.zm.system.service.UserService;
import com.zm.zmcommon.common.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * Create by Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 16:08:32
 */

@RestController
public class OpenSystemController implements OpenSystem {

    @Autowired
    UserService userService;

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity getOne(Long id) {
        return ResponseEntity.success(userService.getOne(id));
    }

    /**
     * 查询全部 可带条件
     *
     * @param user
     * @return
     */
    @Override
    public ResponseEntity list(UserQo user) {
        return ResponseEntity.success(userService.list(user));
    }

    /**
     * 查全部 可带条件分页
     *
     * @param user
     * @return
     */
    @Override
    public ResponseEntity listByPage(UserQo user) {
        return ResponseEntity.success(userService.listByPage(user));
    }

    /**
     * 带ID更新 不带ID新增
     *
     * @param user
     * @return
     */
    @Override
    public ResponseEntity saveOrUpdate(UserQo user) {
        return ResponseEntity.success(userService.save(user));
    }

    /**
     * 根据id删除   多个用,隔开
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseEntity delete(String ids) {
        return ResponseEntity.success(userService.delete(ids));
    }


}