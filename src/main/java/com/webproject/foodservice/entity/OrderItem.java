package com.webproject.foodservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="unit_price")
    private BigDecimal unitPrice;
    @Column(name="quantity")
    private int quantity;
    @Column(name="product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public OrderItem() {
    }

    public OrderItem(String imageUrl, BigDecimal unitPrice, int quantity, Long productId, Order order) {

        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.productId = productId;
        this.order = order;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
