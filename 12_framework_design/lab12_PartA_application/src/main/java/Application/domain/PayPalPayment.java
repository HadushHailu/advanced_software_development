package Application.domain;

import org.ShoppingFramework.domain.PaymentType;

public class PayPalPayment implements PaymentType {
    private String address;

    public PayPalPayment(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "address='" + address + '\'' +
                '}';
    }
}
