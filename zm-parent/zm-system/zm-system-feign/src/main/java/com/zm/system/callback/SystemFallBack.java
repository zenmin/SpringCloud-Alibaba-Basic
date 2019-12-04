package com.zm.system.callback;

import com.zm.system.bean.UserQo;
import com.zm.system.service.UserFeignService;
import com.zm.zmcommon.common.ResponseEntity;

/**
 * @Describle This Class Is 服务降级详细
 * @Author ZengMin
 * @Date 2019/11/13 20:15
 */
public class SystemFallBack implements UserFeignService {

    private Throwable throwable;

    SystemFallBack(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public ResponseEntity getOne(Long id) {
        return ResponseEntity.error("暂无数据");
    }

    @Override
    public ResponseEntity list(UserQo user) {
        return null;
    }

    @Override
    public ResponseEntity listByPage(UserQo user) {
        return null;
    }

    @Override
    public ResponseEntity saveOrUpdate(UserQo user) {
        return null;
    }

    @Override
    public ResponseEntity delete(String ids) {
        return null;
    }

    @Override
    public ResponseEntity send(String msg) {
        return null;
    }

    @Override
    public ResponseEntity decrAccount(UserQo user) {
        return ResponseEntity.error("库存不足");
    }

}