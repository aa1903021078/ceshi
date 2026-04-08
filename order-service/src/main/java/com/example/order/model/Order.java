package com.example.order.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体类
 */
public class Order {

    /** 订单ID */
    private Long id;

    /** 订单编号 */
    private String orderNo;

    /** 商品名称 */
    private String productName;

    /** 订单金额 */
    private BigDecimal amount;

    /** 订单状态：PENDING-待支付, PAID-已支付, SHIPPED-已发货, DELIVERED-已收货, CANCELLED-已取消 */
    private String status;

    /** 收货人姓名 */
    private String receiverName;

    /** 收货地址 */
    private String receiverAddress;

    /** 下单时间 */
    private LocalDateTime createTime;

    public Order() {
    }

    public Order(Long id, String orderNo, String productName, BigDecimal amount,
                 String status, String receiverName, String receiverAddress,
                 LocalDateTime createTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
