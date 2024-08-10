package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dao.ProductDAO;
import webshop.domain.Product;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

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
