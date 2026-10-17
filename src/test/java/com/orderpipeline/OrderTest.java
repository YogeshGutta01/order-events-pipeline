package com.orderpipeline;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void totalAddsAllItems() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, new BigDecimal("10.00")));
        order.addItem(new OrderItem("B", 1, new BigDecimal("5.50")));
        assertEquals(new BigDecimal("25.50"), order.total());
    }

    @Test
    void newOrderStartsAsCreated() {
        assertEquals(OrderStatus.CREATED, new Order().getStatus());
    }

    @Test
    void payMovesOrderToPaid() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 1, BigDecimal.ONE));
        order.pay();
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void cannotPayEmptyOrder() {
        assertThrows(IllegalStateException.class, () -> new Order().pay());
    }

    @Test
    void cannotShipBeforePaying() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 1, BigDecimal.ONE));
        assertThrows(IllegalStateException.class, order::ship);
    }

    @Test
    void rejectsInvalidQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("A", 0, BigDecimal.ONE));
    }
}
