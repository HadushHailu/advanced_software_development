package org.ShoppingFramework.dao;

import org.ShoppingFramework.domain.Order;

import java.util.HashMap;


public class OrderDAO {
    private HashMap<String, Order> orderHashMap = new HashMap<>();

    public void save(Order order){
        orderHashMap.put(order.getOrderId(), order);
    }

    public Order find(String orderID){
        return orderHashMap.get(orderID);
    }

    public void remove(String orderID){
        orderHashMap.remove(orderID);
    }

}
