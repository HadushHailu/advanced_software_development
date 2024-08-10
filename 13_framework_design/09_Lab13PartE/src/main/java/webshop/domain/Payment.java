package webshop.domain;

import java.time.LocalDate;
import java.util.Date;

public class Payment implements PaymentType{
    private double amount;
    private LocalDate date;
    private PaymentType paymentType;

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", date=" + date +
                ", paymentType=" + paymentType +
                '}';
    }

    public Payment(double amount, LocalDate date, PaymentType paymentType) {
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
