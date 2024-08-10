package Application;

import Application.domain.InternationalAddress;
import Application.domain.PayPalPayment;
import org.ShoppingFramework.domain.*;
import org.ShoppingFramework.service.OrderService;
import org.ShoppingFramework.service.ProductService;
import org.ShoppingFramework.service.ShoppingCartService;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        ProductService productService = new ProductService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        OrderService orderService = new OrderService();

        //product
        productService.addProduct("iphone", 1200, 200);
        Product productRocket = new Product("rocket", 8000000, 100);
        productService.addProduct("Tesla", 120000, 400);
        productService.saveProduct(productRocket);
        System.out.println(productService.getAllProducts());

        //shopping cart

        shoppingCartService.createCart("WM-101");
        CartLine cartLine1 = new CartLine(3, productService.getProduct("iphone"));
        shoppingCartService.addToCart("WM-101", cartLine1);

        CartLine cartLine2 = new CartLine(20, productRocket);
        shoppingCartService.addToCart("WM-101", cartLine2);

        System.out.println(productService.getAllProducts());

        //Change quantity
        shoppingCartService.changeQuantity("WM-101", "iphone", 10);
        System.out.println(productService.getAllProducts());

        // order
        Customer customer = new Customer("Frank", "fbrown@miu.edu", "+16412330225");
        Address address = new InternationalAddress("Jefferson", "Fairfield", "52557", "USA");
        orderService.createOrder("WM-101-ORDER", LocalDate.now() , shoppingCartService.getShoppingCart("WM-101"));
        //shoppingCart is deleted
        Order order = orderService.findOrder("WM-101-ORDER");
        order.setCustomer(customer);
        order.setBilling(address);
        order.setShipping(address);
        PaymentType paymentType = new CreditCardPayment("43297-32432-3432", LocalDate.of(2028, 4, 12), "VISA");
        PaymentType paymentType1 = new PayPalPayment("had@gmail.com");
        order.setPayment(new Payment(234.90, LocalDate.now(), paymentType1));
        orderService.saveOrder(order);
        //Change state of order when placing it
        orderService.placeOrder(order);
        System.out.println(orderService.findOrder("WM-101-ORDER"));
    }
}