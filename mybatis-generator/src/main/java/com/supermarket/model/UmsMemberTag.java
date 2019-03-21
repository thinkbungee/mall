package com.supermarket.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UmsMemberTag implements Serializable {
    private Long id;

    private String name;

    /**
    *自动打标签完成订单数量
     *
     * @mbggenerated
     */
    private Integer finishOrderCount;

    /**
    *自动打标签完成订单金额
     *
     * @mbggenerated
     */
    private BigDecimal finishOrderAmount;

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

    public Integer getFinishOrderCount() {
        return finishOrderCount;
    }

    public void setFinishOrderCount(Integer finishOrderCount) {
        this.finishOrderCount = finishOrderCount;
    }

    public BigDecimal getFinishOrderAmount() {
        return finishOrderAmount;
    }

    public void setFinishOrderAmount(BigDecimal finishOrderAmount) {
        this.finishOrderAmount = finishOrderAmount;
    }
}