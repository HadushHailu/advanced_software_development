package customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public AgeIterator<Customer> ageIterator() {
		return new AgeIterator<>(customers);
	}

}
