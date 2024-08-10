package visitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Order {
    private Date date;
    private double amount;
    private String state;
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order(Date date, double amount, String state) {
        this.date = date;
        this.amount = amount;
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getState() {
        return state;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
        this.amount += orderLine.getTotal();
    }

    public abstract void accept(OrderVisitor visitor);
}
