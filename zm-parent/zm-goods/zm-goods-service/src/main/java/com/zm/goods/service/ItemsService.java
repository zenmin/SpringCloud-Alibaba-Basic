package com.zm.goods.service;

import com.zm.goods.bean.ItemsQo;
import com.zm.goods.entity.Items;
import com.zm.zmcommon.common.Pager;

import java.util.List;

/**
 * Create by Code Generator
 *
 * @Author ZengMin
 * @Date 2019-11-07 10:17:53
 */

public interface ItemsService {

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    Items getOne(Long id);

    /**
     * 不分页查询
     *
     * @param items
     * @return
     */
    List<Items> list(ItemsQo items);

    /**
     * 分页查询
     *
     * @return
     */
    Pager listByPage(ItemsQo itemsQo);

    /**
     * 新增或更新
     *
     * @param items
     * @return
     */
    ItemsQo save(ItemsQo items);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    boolean delete(String ids);


}
