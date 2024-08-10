package org.ShoppingFramework.service;


import org.ShoppingFramework.dao.ProductDAO;
import org.ShoppingFramework.domain.Product;

import java.util.Collection;

public class ProductService {
    ProductDAO productDAO;

    public ProductService(){
        productDAO = new ProductDAO();
    }
    public void addProduct(String name, double price, int availableQuantity){
        Product product = new Product(name, price, availableQuantity);
        productDAO.save(product);
    }

    public void saveProduct(Product product){
        productDAO.save(product);
    }

    public Product getProduct(String name){
        return productDAO.find(name);
    }

    public Collection<Product> getAllProducts(){
        return productDAO.getProducts();
    }

    public void removeProduct(String name){
        productDAO.remove(name);
    }

}
