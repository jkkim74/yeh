package com.jk.shop.coffee.yeh;

import com.jk.shop.coffee.yeh.domains.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Component
@Transactional
public class yehShopRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member member = new Member();
        member.setName("jack68");
        member.setCity("bundang");

        Item item = new Item();
        item.setName("eletronic cycle");

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(1200000);
        orderItem.setItem(item);

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.ORDER);
        order.setMember(member);

        order.addOrderItem(orderItem);

        em.persist(order);

    }
}
