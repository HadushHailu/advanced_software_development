package customer.dao;

public class CustomerRatingEvent {
    private String message;
    public CustomerRatingEvent(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
