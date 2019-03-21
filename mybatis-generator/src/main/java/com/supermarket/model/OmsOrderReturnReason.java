package com.supermarket.model;

import java.io.Serializable;
import java.util.Date;

public class OmsOrderReturnReason implements Serializable {
    private Long id;

    /**
    *退货类型
     *
     * @mbggenerated
     */
    private String name;

    private Integer sort;

    /**
    *状态：0->不启用；1->启用
     *
     * @mbggenerated
     */
    private Integer status;

    /**
    *添加时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}