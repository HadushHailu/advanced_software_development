package visitor;

import java.util.Date;

public class InternalOrder extends Order{
    private String department;

    public InternalOrder(Date date, double amount, String state, String department) {
        super(date, amount, state);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }
}
