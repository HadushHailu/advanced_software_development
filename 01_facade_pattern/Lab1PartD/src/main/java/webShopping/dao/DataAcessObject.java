package webShopping.dao;

import webShopping.domain.*;

import java.util.HashMap;
import java.util.Map;

public class DataAcessObject {
    private Map<Long, Customer> customers = new HashMap<>();
    private Map<String, Book> books = new HashMap<>();
    private Map<Long, BookCopy> bookCopies = new HashMap<>();
    private Map<Long, Address> addresses = new HashMap<>();
    private Map<String, Order> orders = new HashMap<>();
    private Map<Long, ShippingCart> shippingCarts = new HashMap<>();

    // Customer Methods
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(Long id) {
        return customers.get(id);
    }

    // Book Methods
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    // BookCopy Methods
    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.put(bookCopy.getId(), bookCopy);
    }

    public BookCopy getBookCopy(Long id) {
        return bookCopies.get(id);
    }

    // Address Methods
    public void addAddress(Long id, Address address) {
        addresses.put(id, address);
    }

    public Address getAddress(Long id) {
        return addresses.get(id);
    }

    // Order Methods
    public void addOrder(Order order) {
        orders.put(order.getOrderNumber(), order);
    }

    public Order getOrder(String orderNumber) {
        return orders.get(orderNumber);
    }

    // ShippingCart Methods
    public void addShippingCart(ShippingCart shippingCart) {
        shippingCarts.put(shippingCart.getId(), shippingCart);
    }

    public ShippingCart getShippingCart(Long id) {
        return shippingCarts.get(id);
    }
}
