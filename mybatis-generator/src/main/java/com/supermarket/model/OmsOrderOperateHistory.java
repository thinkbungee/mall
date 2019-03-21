package com.supermarket.model;

import java.io.Serializable;
import java.util.Date;

public class OmsOrderOperateHistory implements Serializable {
    private Long id;

    /**
    *订单id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
    *操作人：用户；系统；后台管理员
     *
     * @mbggenerated
     */
    private String operateMan;

    /**
    *操作时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
    *订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     *
     * @mbggenerated
     */
    private Integer orderStatus;

    /**
    *备注
     *
     * @mbggenerated
     */
    private String note;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}