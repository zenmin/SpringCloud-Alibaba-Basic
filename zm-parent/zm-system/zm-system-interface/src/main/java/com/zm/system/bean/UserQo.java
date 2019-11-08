package com.zm.system.bean;

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
 * @Date 2019-11-07 16:08:32
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserQo extends Pager {

    private Long id;

    private String name;

    private String pwd;

    private Boolean sex;


}
