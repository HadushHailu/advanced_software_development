package webshop.domain;

public class InternationalAddress extends Address{
    private String country;

    public InternationalAddress(String street, String city, String zip, String country){
        super(street, city, zip);
        this.country = country;
    }

    @Override
    public String toString() {
        return "InternationalAddress{" +
                "country='" + country + '\'' +
                ", zip='" + getZip() + '\'' +
                ", city='" + getCity() + '\'' +
                ", street='" + getStreet() + '\'' +
                '}';
    }
}
