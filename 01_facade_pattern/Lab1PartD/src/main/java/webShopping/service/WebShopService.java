package webShopping.service;

import webShopping.dao.DataAcessObject;
import webShopping.domain.*;

public class WebShopService {
    private DataAcessObject dao;

    public WebShopService() {
    }

    public WebShopService(DataAcessObject dao) {
        this.dao = dao;
    }


    public void registerCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    public Customer findCustomer(Long id) {
        return dao.getCustomer(id);
    }


    public void addBook(Book book) {
        dao.addBook(book);
    }

    public Book findBook(String isbn) {
        return dao.getBook(isbn);
    }


    public void addBookCopy(BookCopy bookCopy) {
        dao.addBookCopy(bookCopy);
    }

    public BookCopy findBookCopy(Long id) {
        return dao.getBookCopy(id);
    }


    public void addAddress(Long id, Address address) {
        dao.addAddress(id, address);
    }

    public Address findAddress(Long id) {
        return dao.getAddress(id);
    }


    public void placeOrder(Order order) {
        dao.addOrder(order);
    }

    public Order findOrder(String orderNumber) {
        return dao.getOrder(orderNumber);
    }

    // ShippingCart Service Methods
    public void addShippingCart(ShippingCart shippingCart) {
        dao.addShippingCart(shippingCart);
    }

    public ShippingCart findShippingCart(Long cartId) {
        return dao.getShippingCart(cartId);
    }

    public void addProductToCart(Long cartId, Book book, int quantity) {
        ShippingCart cart = dao.getShippingCart(cartId);
        if (cart != null) {
            cart.addItem(book, quantity);
            // Optionally, update the cart in the DAO if necessary
        } else {
            throw new IllegalArgumentException("Shopping cart not found.");
        }
    }

    public void removeProductFromCart(Long cartId, Book book) {
        ShippingCart cart = dao.getShippingCart(cartId);
        if (cart != null) {
            cart.removeItem(book);
            // Optionally, update the cart in the DAO if necessary
        } else {
            throw new IllegalArgumentException("Shopping cart not found.");
        }
    }

    public void changeProductQuantityInCart(Long cartId, Book book, int quantity) {
        ShippingCart cart = dao.getShippingCart(cartId);
        if (cart != null) {
            cart.changeQuantity(book, quantity);
            // Optionally, update the cart in the DAO if necessary
        } else {
            throw new IllegalArgumentException("Shopping cart not found.");
        }
    }

    public ShippingCart getShoppingCart(Long cartId) {
        return dao.getShippingCart(cartId);
    }
}
