package with.templatemethod;

public class PaypalPayment extends ProcessPayment{

    @Override
    public void validate(){
        // logic to validate paypal address
        System.out.println("Validate paypal address "+ ((Paypal)getPaymentType()).getAddress());

        // logic to perform paypal payment
        System.out.println("Perform payment with paypal address "+((Paypal)getPaymentType()).getAddress()+" and amount $"+getDollarAmount());

        // logic to notify customer
        System.out.println("Notify customer "+getCustomer().getName()+" with email "+getCustomer().getEmail()+" about paypal payment to address "+((Paypal)getPaymentType()).getAddress());
    }
}
