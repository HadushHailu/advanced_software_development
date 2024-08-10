package webshop.dao;

import org.springframework.stereotype.Repository;
import webshop.domain.Product;
import webshop.domain.ShoppingCart;

import java.util.HashMap;

@Repository
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
