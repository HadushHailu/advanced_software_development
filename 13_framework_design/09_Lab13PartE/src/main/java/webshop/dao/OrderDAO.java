package webshop.dao;

import org.springframework.stereotype.Repository;
import webshop.domain.Order;
import webshop.domain.Product;

import java.util.HashMap;

@Repository
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
