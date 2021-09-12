package com.jk.shop.coffee.yeh.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if(this.member != null ){
         this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
