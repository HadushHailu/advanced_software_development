package with.templatemethod;

import without.templatemethod.Customer;
import without.templatemethod.PaymentProcessor;
import without.templatemethod.VisaCard;

public class Application {

	public static void main(String[] args) {
//		without.templatemethod.Customer customer1 = new without.templatemethod.Customer("Frank Brown", "fbrown@gmail.com");
//		without.templatemethod.VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
//		PaymentProcessor paymentProcessor = new PaymentProcessor();
//		paymentProcessor.proccessPayment(125.75, "USD", "visa", customer1, visaCard, null);
//
//		System.out.println("------------------------------------");
//
//		without.templatemethod.Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
//		paymentProcessor.proccessPayment(175000.0, "INR", "paypal", customer2, null, "jdoe@gmail.com");

		with.templatemethod.ProcessPayment paymentProcessor1;
		with.templatemethod.Customer customer1 = new with.templatemethod.Customer("Frank Brown", "fbrown@gmail.com");
		Object visaCard1 = new with.templatemethod.VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
		paymentProcessor1 = new VisaCardPayment();
		paymentProcessor1.process(125.75, "USD", customer1, visaCard1);

		System.out.println("------------------------------------");

		with.templatemethod.Customer customer2 = new with.templatemethod.Customer("John Doe", "jdoe@gmail.com");
		Object paypal1 = new Paypal("jdoe@gmail.com");
		paymentProcessor1 = new PaypalPayment();
		paymentProcessor1.process(175000.0, "INR", customer2, paypal1);

	}
}
