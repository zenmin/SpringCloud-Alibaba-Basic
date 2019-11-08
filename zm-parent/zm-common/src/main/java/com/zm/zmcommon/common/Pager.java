package com.zm.zmcommon.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Describle This Class Is 分页实体
 * @Author ZengMin
 * @Date 2019/3/15 9:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pager<T> implements Serializable {

    @ApiModelProperty(value = "页码")
    private Long num = 0L;

    @ApiModelProperty(value = "分页大小")
    private Long size = 10L;

    @ApiModelProperty(hidden = true)
    private List<T> data;

    @ApiModelProperty(hidden = true)
    private Boolean last;

    @ApiModelProperty(hidden = true)
    private Long totalNums;

    @ApiModelProperty(hidden = true)
    private Long totalPages;

    public static Pager of(IPage iPage) {
        return new Pager<>(iPage.getCurrent(), iPage.getSize(), iPage.getRecords(), iPage.getPages() <= iPage.getCurrent(), iPage.getTotal(), iPage.getPages());
    }

    public static Pager of(List<?> list, Pager pager, Long allCount) {
        int pages = Math.toIntExact(allCount % pager.getSize()) == 0 ? Math.toIntExact(allCount / pager.getSize()) : Math.toIntExact(allCount / pager.getSize()) + 1;
        return new Pager<>(pager.getNum(), pager.getSize(), list, pages <= pager.getNum(), allCount, (long) pages);
    }

    public Pager(long num, long size) {
        this.num = num;
        this.size = size;
    }
}
