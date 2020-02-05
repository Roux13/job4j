package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenTwoOrders() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("3sfe", "Dress");
        Order order2 = new Order("6bca", "Shirt");
        orders.add(order1);
        orders.add(order2);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get(order2.getNumber()), is(order2));
    }

    @Test
    public void whenOrderIsNull() {
        List<Order> orders = new ArrayList<>();
        Order order1 = null;
        Order order2 = new Order("6bca", "Shirt");
        orders.add(order1);
        orders.add(order2);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get(order2.getNumber()), is(order2));
    }

    @Test
    public void whenOrdersNumberIsNull() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order(null, "Dress");
        Order order2 = new Order("6bca", "Shirt");
        orders.add(order1);
        orders.add(order2);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get(order2.getNumber()), is(order2));
    }

}