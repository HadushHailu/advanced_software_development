package webShopping.domain;

import java.util.HashMap;
import java.util.Map;

public class ShippingCart {
    private Long id;
    private Map<Book, Integer> items = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public void addItem(Book book, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        items.put(book, items.getOrDefault(book, 0) + quantity);
    }

    public void removeItem(Book book) {
        items.remove(book);
    }

    public void changeQuantity(Book book, int quantity) {
        if (quantity <= 0) { //What if the quantity is Zero or negative - delete the book
            removeItem(book);
        } else if (items.containsKey(book)) {
            items.put(book, quantity);
        }
    }

    public Integer getQuantity(Book book) {
        return items.get(book);
    }
}
