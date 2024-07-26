package webShopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webShopping.dao.DataAcessObject;
import webShopping.domain.*;
import webShopping.service.WebShopService;


@SpringBootApplication
public class Lab1PartDApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab1PartDApplication.class, args);
	}

	public void run(String... args) throws Exception{
		// Create test data
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setName("John Doe");
		customer1.setEmail("john.doe@example.com");
		customer1.setPhone("123-456-7890");

		Book book1 = new Book();
		book1.setIsbn("978-0134685991");
		book1.setTitle("Effective Java");
		book1.setAuthor("Joshua Bloch");
		book1.setPrice(45.00);

		Book book2 = new Book();
		book2.setIsbn("978-0201633610");
		book2.setTitle("Design Patterns");
		book2.setAuthor("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
		book2.setPrice(55.00);

		ShippingCart cart1 = new ShippingCart();
		cart1.setId(1L);

		// Add data to the service
		WebShopService service = new WebShopService(new DataAcessObject());
		service.registerCustomer(customer1);
		service.addBook(book1);
		service.addBook(book2);
		service.addShippingCart(cart1);

		// Add products to the shopping cart
		service.addProductToCart(1L, book1, 2);
		service.addProductToCart(1L, book2, 1);

		// Retrieve and print the shopping cart
		ShippingCart cart = service.getShoppingCart(1L);
		System.out.println("Shopping Cart Contents:");
		cart.getItems().forEach((book, quantity) ->
				System.out.println(book.getTitle() + ": " + quantity + " copies")
		);

		// Change quantity of a product
		service.changeProductQuantityInCart(1L, book1, 3); // Change quantity of "Effective Java" to 3

		// Remove a product from the cart
		service.removeProductFromCart(1L, book2); // Remove "Design Patterns"

		// Retrieve and print the shopping cart again
		ShippingCart updatedCart = service.getShoppingCart(1L);
		System.out.println("Updated Shopping Cart Contents:");
		updatedCart.getItems().forEach((book, quantity) ->
				System.out.println(book.getTitle() + ": " + quantity + " copies")
		);
	}

}
