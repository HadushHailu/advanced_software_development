package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import webshop.domain.*;
import webshop.service.OrderService;
import webshop.service.ProductService;
import webshop.service.ShoppingCartService;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class webShopApplication implements CommandLineRunner {
	@Autowired
	ProductService productService;
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(webShopApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//product 1
		productService.addProduct("iphone", 1200);
		System.out.println(productService.getProduct("iphone"));

		shoppingCartService.createCart("WM-101");
		CartLine cartLine1 = new CartLine(3, productService.getProduct("iphone"));
		shoppingCartService.addToCart("WM-101", cartLine1);

		//product 2
		Product product = new Product("rocket", 8000000);
		CartLine cartLine2 = new CartLine(20, product);
		productService.addProduct("iphone", 1200);
		shoppingCartService.addToCart("WM-101", cartLine2);

		//Change quantity
		shoppingCartService.changeQuantity("WM-101", "iphone", 10);
		System.out.println(shoppingCartService.getShoppingCart("WM-101"));

		// order
		Customer customer = new Customer("Frank", "fbrown@miu.edu", "+16412330225");
		Address address = new Address("Jefferson", "Fairfield", "52557");
		orderService.createOrder("WM-101-ORDER", LocalDate.now() , shoppingCartService.getShoppingCart("WM-101"));
		//shoppingCart is deleted
		System.out.println("shpping cart: " + shoppingCartService.getShoppingCart("WM-101"));
		Order order = orderService.findOrder("WM-101-ORDER");
		order.setCustomer(customer);
		order.setBilling(address);
		order.setShipping(address);
		PaymentType paymentType = new CreditCardPayment("43297-32432-3432", LocalDate.of(2028, 4, 12), "VISA");
		order.setPaymentType(new Payment(234.90, LocalDate.now(), paymentType));
		orderService.saveOrder(order);
		System.out.println(orderService.findOrder("WM-101-ORDER"));
		//Change state of order when placing it
		orderService.placeOrder(order);
		System.out.println(orderService.findOrder("WM-101-ORDER"));

	}
}
