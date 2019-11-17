package com.zm.goods.bean;

import com.zm.zmcommon.common.Pager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Create by Code Generator
 * JPA只用来正向生成数据库表和字段 如果不需要此字段更新 请加上注解@TableField(exist = false)和@Transient
 *
 * @Author ZengMin
 * @Date 2019-11-07 10:17:53
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemsQo extends Pager {

    private Long id;

    private String gid;

    private String gname;

    private Integer cid;

    private Integer stock;

    private Double price;

    private String userName;

    private String userId;

    public ItemsQo(Long num, Long size, Long id, String name) {
        super.setNum(num);
        super.setSize(size);
        this.id = id;
        this.gname = name;
    }

}
