package org.ShoppingFramework.domain;

import java.time.LocalDate;

public class CreditCardPayment implements PaymentType{
    private String creditCardNumber;
    private LocalDate validationDate;
    private String type;

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", validationDate=" + validationDate +
                ", type='" + type + '\'' +
                '}';
    }

    public CreditCardPayment(String creditCardNumber, LocalDate validationDate, String type) {
        this.creditCardNumber = creditCardNumber;
        this.validationDate = validationDate;
        this.type = type;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
