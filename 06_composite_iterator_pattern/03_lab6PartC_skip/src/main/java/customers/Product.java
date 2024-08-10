package customers;

public class Product extends Catalog{
    private int quantity;
    private double price;

    Product(String name, int quantity, double price){
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
