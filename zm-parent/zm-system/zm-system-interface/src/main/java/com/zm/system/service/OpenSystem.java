package com.zm.system.service;

import com.zm.system.bean.UserQo;
import com.zm.zmcommon.common.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 20:38
 */
public interface OpenSystem {

    String PREFIX = "/api/user";

    @PostMapping(PREFIX + "/getOne")
    ResponseEntity getOne(@RequestParam("id") Long id);

    /**
     * 查询全部 可带条件
     *
     * @param user
     * @return
     */
    @PostMapping(PREFIX + "/list")
    ResponseEntity list(@RequestBody UserQo user);

    /**
     * 查全部 可带条件分页
     *
     * @param user
     * @return
     */
    @PostMapping(PREFIX + "/listByPage")
    ResponseEntity listByPage(@RequestBody UserQo user);

    /**
     * 带ID更新 不带ID新增
     *
     * @param user
     * @return
     */
    @PostMapping(PREFIX + "/save")
    ResponseEntity saveOrUpdate(@RequestBody UserQo user);

    /**
     * 根据id删除   多个用,隔开
     *
     * @param ids
     * @return
     */
    @PostMapping(PREFIX + "/delete")
    ResponseEntity delete(@RequestParam("ids") String ids);

    /**
     * 测试消息发送
     *
     * @param msg
     * @return
     */
    @PostMapping(PREFIX + "/send")
    ResponseEntity send(@RequestParam("msg") String msg);

    /**
     * 带ID更新 不带ID新增
     *
     * @param user
     * @return
     */
    @PostMapping(PREFIX + "/decrAccount")
    ResponseEntity decrAccount(@RequestBody UserQo user);

}
