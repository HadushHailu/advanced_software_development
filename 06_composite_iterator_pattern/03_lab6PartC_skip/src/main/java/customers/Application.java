package customers;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		Category store = new Category("store");
	  	Category phone = new Category("Phone");
	  	Product iphone = new Product("Iphone", 10, 990);
	  	Product samsung = new Product("Samsung", 8, 870);
	  	Product motorola = new Product("Motorola", 100, 20);
	  	Product blackberry = new Product("Blackberry", 20, 50);
	  	Product nokia = new Product("Nokia", 23, 34);
	  	Product ajax = new Product("Ajax", 23, 98);
	  	Product techno = new Product("Techno", 45, 90);
	  	Category functional = new Category("Functional");
	  	Category smallScreen = new Category("Small Screen");
	  	Category bigScreen = new Category("Big Screen");
		phone.addComponent(iphone);
	  	phone.addComponent(samsung);
	  	phone.addComponent(functional);
	  	functional.addComponent(motorola);
	  	functional.addComponent(blackberry);
	  	functional.addComponent(smallScreen);
	  	functional.addComponent(bigScreen);
	  	smallScreen.addComponent(nokia);
	  	bigScreen.addComponent(ajax);
	  	bigScreen.addComponent(techno);

	  	Category car = new Category("Car");
	  	Product ford = new Product("Ford", 89, 40000);
	  	Product tesla = new Product("Tesla", 0, 90000);
		car.addComponent(ford);
		car.addComponent(tesla);

		store.addComponent(phone);
		store.addComponent(car);



	  System.out.println(store);

	}

}
