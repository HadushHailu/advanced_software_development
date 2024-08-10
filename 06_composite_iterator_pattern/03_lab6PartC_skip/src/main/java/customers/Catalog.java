package customers;

public abstract class Catalog {
    protected String name;
    Catalog(String name){
        this.name = name;
    }

    abstract int getQuantity();
    abstract double getPrice();

}
