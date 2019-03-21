package com.supermarket.model;

import java.io.Serializable;

public class PmsProductCategory implements Serializable {
    private Long id;

    /**
    *上机分类的编号：0表示一级分类
     *
     * @mbggenerated
     */
    private Long parentId;

    private String name;

    /**
    *分类级别：0->1级；1->2级
     *
     * @mbggenerated
     */
    private Integer level;

    private Integer productCount;

    private String productUnit;

    /**
    *是否显示在导航栏：0->不显示；1->显示
     *
     * @mbggenerated
     */
    private Integer navStatus;

    /**
    *显示状态：0->不显示；1->显示
     *
     * @mbggenerated
     */
    private Integer showStatus;

    private Integer sort;

    /**
    *图标
     *
     * @mbggenerated
     */
    private String icon;

    private String keywords;

    /**
    *描述
     *
     * @mbggenerated
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}