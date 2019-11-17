package com.zm.goods.entity;

import com.zm.goods.bean.ItemsQo;
import com.zm.zmcommon.bean.AbstractEntityModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by Code Generator
 * JPA只用来正向生成数据库表和字段 如果不需要此字段更新 请加上注解@TableField(exist = false)和@Transient
 *
 * @Author ZengMin
 * @Date 2019-11-07 10:17:53
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "items")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Items extends AbstractEntityModel {

    private String gid;

    private String gname;

    private Integer cid;

    private Integer stock;

    private Double price;

    private String userName;

    private String userId;

    public static Items of(ItemsQo itemsVo) {
        Items items = new Items();
        BeanUtils.copyProperties(itemsVo, items);
        return items;
    }

    public Items(String userId, String userName) {
        this.userName = userName;
        this.userId = userId;
    }
}
