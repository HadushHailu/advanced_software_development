package org.ShoppingFramework.dao;

import org.ShoppingFramework.domain.Product;

import java.util.Collection;
import java.util.HashMap;


public class ProductDAO {
    private HashMap<String, Product> productHashMap = new HashMap<>();

    public void save(Product product){
        productHashMap.put(product.getName(), product);
    }

    public Product find(String name){
        return productHashMap.get(name);
    }

    public void remove(String name){
        productHashMap.remove(name);
    }

    public Collection<Product> getProducts(){
        return productHashMap.values();
    }


}
