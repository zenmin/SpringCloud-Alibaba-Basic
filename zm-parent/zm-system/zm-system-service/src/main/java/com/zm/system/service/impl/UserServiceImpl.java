package com.zm.system.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.zm.system.bean.UserQo;
import com.zm.system.entity.User;
import com.zm.system.mapper.UserMapper;
import com.zm.system.service.RocketMqProducer;
import com.zm.system.service.UserService;
import com.zm.zmcommon.common.CommonException;
import com.zm.zmcommon.common.Pager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * Create Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 16:08:32
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RocketMqProducer rocketMqProducer;

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

        // 修改完成  发送消息到商品服务
        if (Objects.nonNull(user.getId()) && StringUtils.isNotBlank(user.getName())) {
            this.send(JSONUtils.toJSONString(ImmutableMap.of("id", user.getId(), "name", user.getName())));
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

    @Override
    public void send(String msg) {
        try {
            // 此处header中的key不能使用TAGS 官方demo里面使用了  估计升级rocketmq版本后  TAGS是保留字段
            Message message = MessageBuilder.withPayload(msg).setHeader("MY-HEADER", "default-tag").build();
            rocketMqProducer.output().send(message);
            log.info("消息的发送完成：{}", msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
