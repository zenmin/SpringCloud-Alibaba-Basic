package com.zm.zmweb.controller;

import com.zm.system.bean.UserQo;
import com.zm.system.service.UserFeignService;
import com.zm.zmcommon.common.Pager;
import com.zm.zmcommon.common.ResponseEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 11:02
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理")
public class SystemFeignController {

    @Autowired
    UserFeignService userFeignService;

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @PostMapping("/getOne")
    public ResponseEntity getOne(Long id) {
        return userFeignService.getOne(id);
    }

    /**
     * 查询全部 可带条件
     *
     * @return
     */
    @PostMapping("/list")
    public ResponseEntity list(UserQo user) {
        return userFeignService.list(user);
    }

    /**
     * 查全部 可带条件分页
     *
     * @return
     */
    @PostMapping("/listByPage")
    public ResponseEntity listByPage(UserQo user) {
        return userFeignService.listByPage(user);
    }

    /**
     * 带ID更新 不带ID新增
     *
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity saveOrUpdate(UserQo user) {
        return userFeignService.saveOrUpdate(user);
    }

    /**
     * 根据id删除   多个用,隔开
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity delete(String ids) {
        return userFeignService.delete(ids);
    }


}
