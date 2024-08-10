package webshop.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dao.OrderDAO;
import webshop.domain.Order;
import webshop.domain.ShoppingCart;

import java.time.LocalDate;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ShoppingCartService shoppingCartService;

    public void createOrder(String orderID, LocalDate date, ShoppingCart shoppingCart){
        Order order = new Order(orderID, date);
        order.setCartLines(shoppingCart.getCartLines());
        orderDAO.save(order);
        shoppingCartService.removeCart(shoppingCart.getShoppingCartID());
    }

    public Order findOrder(String orderID){
        return orderDAO.find(orderID);
    }

    public void saveOrder(Order order){
        orderDAO.save(order);
    }

    public void placeOrder(Order order){
        Order order1 = orderDAO.find(order.getOrderId());
        order1.setState("ordered");
        orderDAO.save(order);
    }



}
