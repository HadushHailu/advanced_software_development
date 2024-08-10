package webshop.dao;

import org.springframework.stereotype.Repository;
import webshop.domain.Product;

import java.util.HashMap;

@Repository
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


}
