package visitor;

import java.util.Date;

public class CorporateOrder extends Order{
    private String company;
    private String contact;

    public CorporateOrder(Date date, double amount, String state, String company, String contact) {
        super(date, amount, state);
        this.company = company;
        this.contact = contact;
    }

    public String getCompany() {
        return company;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }
}
