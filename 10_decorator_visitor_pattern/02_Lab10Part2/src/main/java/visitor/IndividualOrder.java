package visitor;

import java.util.Date;

public class IndividualOrder extends Order{
    private String name;

    public IndividualOrder(Date date, double amount, String state, String name) {
        super(date, amount, state);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }
}
