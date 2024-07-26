package with.templatemethod;


public abstract class ProcessPayment {
    Customer customer;
    double dollarAmount;
    Object paymentType;

    public void process(double amount, String currency,Customer customer,Object paymentType){
        this.dollarAmount = amount;
        this.customer = customer;
        this.paymentType = paymentType;

        if (currency.contentEquals("EUR")) { // European Euro
            dollarAmount = amount * 1.1;
            System.out.println("Convert "+amount+" "+currency+" to US dollars");

        }
        if (currency.contentEquals("INR")) { // Indian Rupee
            dollarAmount = amount * 0.014;
            System.out.println("Convert "+amount+" "+currency+" to US dollars");

        }

        this.validate();

    }

    abstract void validate();

    public Customer getCustomer() {
        return customer;
    }

    public double getDollarAmount() {
        return dollarAmount;
    }

    public Object getPaymentType() {
        return paymentType;
    }
}
