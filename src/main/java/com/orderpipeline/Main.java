package com.orderpipeline;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new OrderItem("BOOK-101", 2, new BigDecimal("12.50")));
        order.addItem(new OrderItem("PEN-007", 5, new BigDecimal("1.20")));

        System.out.println("Order " + order.getId());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Total:  " + order.total());

        order.pay();
        System.out.println("Status: " + order.getStatus());
    }
}
