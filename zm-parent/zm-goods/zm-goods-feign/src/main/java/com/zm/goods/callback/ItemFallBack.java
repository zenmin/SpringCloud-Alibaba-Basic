package com.zm.goods.callback;

import com.zm.goods.bean.ItemsQo;
import com.zm.goods.service.ItemFeignService;
import com.zm.zmcommon.common.ResponseEntity;

/**
 * @Describle This Class Is 服务降级详细
 * @Author ZengMin
 * @Date 2019/11/13 20:15
 */
public class ItemFallBack implements ItemFeignService {

    private Throwable throwable;

    ItemFallBack(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public ResponseEntity getOne(Long id) {
        return ResponseEntity.error("暂无数据");
    }

    @Override
    public ResponseEntity list(ItemsQo itemsQo) {
        return ResponseEntity.error("暂无数据");
    }

    @Override
    public ResponseEntity listByPage(ItemsQo itemsQo) {
        return ResponseEntity.error("暂无数据");
    }

    @Override
    public ResponseEntity saveOrUpdate(ItemsQo items) {
        return ResponseEntity.error("暂无数据");
    }

    @Override
    public ResponseEntity delete(String ids) {
        return ResponseEntity.error("暂无数据");
    }
}
