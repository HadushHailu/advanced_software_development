package webShopping.domain;

import java.util.Date;

public class Order {
    private String orderNumber;
    private Date dateOfOrder;

    public Order(String orderNumber, Date dateOfOrder) {
        this.orderNumber = orderNumber;
        this.dateOfOrder = dateOfOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
