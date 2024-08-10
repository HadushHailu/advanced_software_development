package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dao.ProductDAO;
import webshop.domain.Product;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public void addProduct(String name, double price){
        Product product = new Product(name, price);
        productDAO.save(product);
    }

    public Product getProduct(String name){
        return productDAO.find(name);
    }

    public void removeProduct(String name){
        productDAO.remove(name);
    }

}
