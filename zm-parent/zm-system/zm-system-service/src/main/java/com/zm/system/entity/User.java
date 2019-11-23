package com.zm.system.entity;

import com.zm.system.bean.UserQo;
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
 * @Date 2019-11-07 16:08:32
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntityModel {

    private String name;

    private String pwd;

    private Boolean sex;

    private Double account;

    public static User of(UserQo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        return user;
    }


}
