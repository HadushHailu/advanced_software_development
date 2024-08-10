package customers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Category extends Catalog{
    private Collection<Catalog> catalogCollections = new ArrayList<Catalog>();
    Category(String name){
        super(name);
    }

    public void addComponent(Catalog catalog){
        catalogCollections.add(catalog);
    }

    @Override
    public int getQuantity() {
        int quantity = 0;
        for(Catalog catalog: catalogCollections){
            quantity += catalog.getQuantity();
        }
        return quantity;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for(Catalog catalog: catalogCollections){
            price += catalog.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return this.toString(0);
    }

    private String toString(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = " ".repeat(indentationLevel * 2);  // 2 spaces per level
        sb.append(indentation).append("Category{name='").append(name).append("'}\n");
        for (Catalog component : catalogCollections) {
            if (component instanceof Category) {
                sb.append(((Category) component).toString(indentationLevel + 1));
            } else {
                sb.append(indentation).append("  ").append(component).append("\n");
            }
        }
        return sb.toString();
    }
}
