package with.templatemethod;

public class VisaCardPayment extends ProcessPayment{
    @Override
    public void validate(){
        // logic to validate visa card
        System.out.println("Validate visa card with card number " + ((VisaCard)getPaymentType()).getCreditCardNumber());

        System.out.println("Perform payment with visa card with card number " + ((VisaCard)getPaymentType()).getCreditCardNumber()
                + " and amount $" + getDollarAmount());

        // logic to notify customer
        System.out.println("Notify customer " + getCustomer().getName() + " with email " + getCustomer().getEmail()
                + " about visa credit card payment with card number " + ((VisaCard)getPaymentType()).getCreditCardNumber());
    }
}
