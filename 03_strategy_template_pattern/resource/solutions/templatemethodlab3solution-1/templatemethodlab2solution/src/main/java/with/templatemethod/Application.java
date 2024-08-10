package with.templatemethod;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Frank Brown", "fbrown@gmail.com");
		VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
		VisaPaymentProcessor visaPaymentProcessor = new VisaPaymentProcessor(visaCard, customer1);
		visaPaymentProcessor.proccessPayment(125.75, "USD");
		
		System.out.println("------------------------------------");
		
		Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
		PaypalPaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor("jdoe@gmail.com", customer2);
		paypalPaymentProcessor.proccessPayment(175000.0, "INR");

		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		Iterator<String> iterator = list.descendingIterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

	}
}
