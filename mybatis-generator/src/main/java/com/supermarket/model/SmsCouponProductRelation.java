package com.supermarket.model;

import java.io.Serializable;

public class SmsCouponProductRelation implements Serializable {
    private Long id;

    private Long couponId;

    private Long productId;

    /**
    *商品名称
     *
     * @mbggenerated
     */
    private String productName;

    /**
    *商品编码
     *
     * @mbggenerated
     */
    private String productSn;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }
}