package org.ShoppingFramework.service;

import org.ShoppingFramework.dao.OrderDAO;
import org.ShoppingFramework.domain.Order;
import org.ShoppingFramework.domain.ShoppingCart;
import org.ShoppingFramework.integration.EmailSender;

import java.time.LocalDate;


public class OrderService {

    OrderDAO orderDAO;
    ShoppingCartService shoppingCartService;
    EmailSender emailSender;

    public OrderService(){
        orderDAO = new OrderDAO();
        shoppingCartService = new ShoppingCartService();
        emailSender = new EmailSender();
    }

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
        order1.setState("Pending");
        orderDAO.save(order);
        emailSender.sendEmail("Order is placed", order.getCustomer().getEmail());
    }



}
