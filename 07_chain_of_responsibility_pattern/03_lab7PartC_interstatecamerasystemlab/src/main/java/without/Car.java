package without;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String firstName;
    private String lastName;
    private String licensePlate;
    private Address address;
    private Boolean isStolen;
    private List<Ticket> tickets = new ArrayList<>();

    public Car(String firstName, String lastName, String licensePlate, boolean isStolen, Address address) {
        this.firstName = firstName;
        this.address = address;
        this.licensePlate = licensePlate;
        this.lastName = lastName;
        this.isStolen = isStolen;
    }

    public Boolean getStolen() {
        return isStolen;
    }

    public void setStolen(Boolean stolen) {
        isStolen = stolen;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket tickets) {
        this.tickets.add(tickets);
    }

    public void removeTicket(Ticket ticket){
        this.tickets.remove(ticket);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
