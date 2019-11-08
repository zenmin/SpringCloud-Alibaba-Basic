package com.zm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zm.system.bean.UserQo;
import com.zm.system.entity.User;
import com.zm.system.mapper.UserMapper;
import com.zm.system.service.UserService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * Create Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 16:08:32
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getOne(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> list(UserQo user) {
        List<User> users = userMapper.selectList(new QueryWrapper<>(User.of(user)));
        return users;
    }

    @Override
    public Pager listByPage(UserQo user) {
        IPage<User> userIPage = userMapper.selectPage(new Page<>(user.getNum(), user.getSize()), new QueryWrapper<>(User.of(user)));
        return Pager.of(userIPage);
    }

    @Override
    @Transactional(rollbackFor = CommonException.class)
    public UserQo save(UserQo user) {
        if (Objects.nonNull(user.getId())) {
            userMapper.updateById(User.of(user));
        } else {
            userMapper.insert(User.of(user));
        }
        return user;
    }

    @Override
    @Transactional(rollbackFor = CommonException.class)
    public boolean delete(String ids) {
        List<Long> list = Lists.newArrayList();
        if (ids.indexOf(",") != -1) {
            List<String> asList = Arrays.asList(ids.split(","));
            asList.stream().forEach(o -> list.add(Long.valueOf(o)));
        } else {
            list.add(Long.valueOf(ids));
        }
        int i = userMapper.deleteBatchIds(list);
        return i > 0;
    }


}
