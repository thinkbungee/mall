package com.supermarket.model;

import java.io.Serializable;

public class UmsMemberTask implements Serializable {
    private Long id;

    private String name;

    /**
    *赠送成长值
     *
     * @mbggenerated
     */
    private Integer growth;

    /**
    *赠送积分
     *
     * @mbggenerated
     */
    private Integer intergration;

    /**
    *任务类型：0->新手任务；1->日常任务
     *
     * @mbggenerated
     */
    private Integer type;

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

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getIntergration() {
        return intergration;
    }

    public void setIntergration(Integer intergration) {
        this.intergration = intergration;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}