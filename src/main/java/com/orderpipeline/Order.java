package com.orderpipeline;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id = UUID.randomUUID();
    private final Instant createdAt = Instant.now();
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.CREATED;

    public void addItem(OrderItem item) {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException("Cannot change an order that is " + status);
        }
        items.add(item);
    }

    public BigDecimal total() {
        return items.stream()
                .map(OrderItem::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void pay() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot pay for an empty order");
        }
        moveTo(OrderStatus.CREATED, OrderStatus.PAID);
    }

    public void ship() {
        moveTo(OrderStatus.PAID, OrderStatus.SHIPPED);
    }

    public void cancel() {
        if (status == OrderStatus.SHIPPED || status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Cannot cancel an order that is " + status);
        }
        status = OrderStatus.CANCELLED;
    }

    private void moveTo(OrderStatus expected, OrderStatus next) {
        if (status != expected) {
            throw new IllegalStateException("Expected " + expected + " but order is " + status);
        }
        status = next;
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }
}
