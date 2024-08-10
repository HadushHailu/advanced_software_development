package visitor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
	public static void main(String[] args) throws Exception {
		// Create some products
		Product tv = new Product("TV", 300);
		Product laptop = new Product("Laptop", 1500);

		// Create some order lines
		OrderLine orderLine1 = new OrderLine(2, tv);
		OrderLine orderLine2 = new OrderLine(1, laptop);

		// Create some orders
		List<Order> orders = new ArrayList<>();
		InternalOrder internalOrder = new InternalOrder(new Date(), 0, "CA", "IT Department");
		internalOrder.addOrderLine(orderLine1);
		internalOrder.addOrderLine(orderLine2);
		orders.add(internalOrder);

		IndividualOrder individualOrder = new IndividualOrder(new Date(), 0, "NY", "John Doe");
		individualOrder.addOrderLine(orderLine1);
		orders.add(individualOrder);

		CorporateOrder corporateOrder = new CorporateOrder(new Date(), 0, "TX", "TechCorp", "Jane Smith");
		corporateOrder.addOrderLine(orderLine2);
		orders.add(corporateOrder);

		// Create visitors
		OrderTypeCounterVisitor typeCounter = new OrderTypeCounterVisitor();
		TotalAmountVisitor totalAmountVisitor = new TotalAmountVisitor();
		TVOrderCountVisitor tvOrderCountVisitor = new TVOrderCountVisitor();

		// Visit orders
		for (Order order : orders) {
			order.accept(typeCounter);
			order.accept(totalAmountVisitor);
			order.accept(tvOrderCountVisitor);
		}

		// Print results
		System.out.println("Internal Orders: " + typeCounter.getInternalOrderCount());
		System.out.println("Individual Orders: " + typeCounter.getIndividualOrderCount());
		System.out.println("Corporate Orders: " + typeCounter.getCorporateOrderCount());

		System.out.println("Total Amount: " + totalAmountVisitor.getTotalAmount());
		System.out.println("Total TVs Ordered: " + tvOrderCountVisitor.getTvCount());
	}
}


