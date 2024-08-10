package org.ShoppingFramework.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String shoppingCartID;
    private List<CartLine> cartLines = new ArrayList<>();

    public ShoppingCart(String shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public void setShoppingCartID(String shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public void addCartLine(CartLine cartLine){
        this.cartLines.add(cartLine);
    }

    public String getShoppingCartID() {
        return shoppingCartID;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartID='" + shoppingCartID + '\'' +
                ", cartLines=" + cartLines +
                '}';
    }
}
