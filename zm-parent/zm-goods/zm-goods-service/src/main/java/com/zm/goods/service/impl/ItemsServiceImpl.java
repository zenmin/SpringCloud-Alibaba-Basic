package com.zm.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.zm.goods.bean.ItemsQo;
import com.zm.goods.entity.Items;
import com.zm.goods.mapper.ItemsMapper;
import com.zm.goods.service.ItemsService;
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
 * @Date 2019-11-07 10:17:53
 */

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsMapper itemsMapper;

    @Override
    public Items getOne(Long id) {
        return itemsMapper.selectById(id);
    }

    @Override
    public List<Items> list(ItemsQo items) {
        List<Items> itemss = itemsMapper.selectList(new QueryWrapper<>(Items.of(items)));
        return itemss;
    }

    @Override
    public Pager listByPage(ItemsQo itemsQo) {
        IPage<Items> itemsIPage = itemsMapper.selectPage(new Page<>(itemsQo.getNum(), itemsQo.getSize()), new QueryWrapper<>(Items.of(itemsQo)));
        return Pager.of(itemsIPage);
    }

    @Override
    @Transactional(rollbackFor = CommonException.class)
    public ItemsQo save(ItemsQo items) {
        if (Objects.nonNull(items.getId())) {
            itemsMapper.updateById(Items.of(items));
        } else {
            itemsMapper.insert(Items.of(items));
        }
        return items;
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
        int i = itemsMapper.deleteBatchIds(list);
        return i > 0;
    }


}
