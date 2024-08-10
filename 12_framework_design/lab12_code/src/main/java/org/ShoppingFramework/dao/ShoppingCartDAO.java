package org.ShoppingFramework.dao;

import org.ShoppingFramework.domain.ShoppingCart;

import java.util.HashMap;

public class ShoppingCartDAO {
    private HashMap<String, ShoppingCart> shoppingCartHashMap = new HashMap<>();

    public void save(ShoppingCart shoppingCart){
        shoppingCartHashMap.put(shoppingCart.getShoppingCartID(), shoppingCart);
    }

    public ShoppingCart find(String shoppingCartID){
        return shoppingCartHashMap.get(shoppingCartID);
    }

    public void remove(String shoppingCartID){
       shoppingCartHashMap.remove(shoppingCartID);
    }

}
