package with.templatemethod;

public class Paypal {
    private String address;

    public Paypal(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
