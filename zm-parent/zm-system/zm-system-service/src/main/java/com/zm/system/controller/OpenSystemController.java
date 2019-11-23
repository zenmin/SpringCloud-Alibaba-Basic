package com.zm.system.controller;

import com.zm.system.bean.UserQo;
import com.zm.system.entity.User;
import com.zm.system.service.OpenSystem;
import com.zm.system.service.UserService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.ResponseEntity;
import com.zm.zmcommon.common.constant.DefinedCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;


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
     * <p>
     * 模拟修改用户名称 使用mq发送消息到商品服务 修改此人创建商品时的用户名称
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

    @Override
    public ResponseEntity send(String msg) {
        userService.send(msg);
        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity decrAccount(UserQo user) {
        // 查询用户账户余额
        User one = userService.getOne(user.getId());
        if (Objects.isNull(one)) {
            return ResponseEntity.error("用户不存在!");
        }
        // 判断余额是否够支付
        Double account = one.getAccount();
        if (account < user.getAccount()) {
            return ResponseEntity.error("用户余额不足!");
        }

        // 执行扣减
        user.setAccount(new BigDecimal(account).subtract(new BigDecimal(user.getAccount())).doubleValue());
        userService.save(user);
        return ResponseEntity.success(true);
    }


}