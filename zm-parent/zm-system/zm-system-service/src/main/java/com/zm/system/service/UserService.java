package com.zm.system.service;

import com.zm.system.bean.UserQo;
import com.zm.system.entity.User;
import com.zm.zmcommon.common.Pager;

import java.util.List;

/**
 * Create by Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 16:08:32
 */

public interface UserService {

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    User getOne(Long id);

    /**
     * 不分页查询
     *
     * @param user
     * @return
     */
    List<User> list(UserQo user);

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    Pager listByPage(UserQo user);

    /**
     * 新增或更新
     *
     * @param user
     * @return
     */
    UserQo save(UserQo user);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    boolean delete(String ids);

    /**
     * 批量删除
     *
     * @param msg
     * @return
     */
    void send(String msg);

}
