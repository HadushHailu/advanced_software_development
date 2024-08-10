package without;

import java.util.Date;

public class Ticket {
    private Date date;
    private double fee;
    private boolean isPaid;

    public Ticket(Date date, double fee, boolean isPaid) {
        this.date = date;
        this.fee = fee;
        this.isPaid = isPaid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
