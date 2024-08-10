package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dao.ShoppingCartDAO;
import webshop.domain.CartLine;
import webshop.domain.Product;
import webshop.domain.ShoppingCart;

import java.util.Iterator;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartDAO shoppingCartDAO;
    @Autowired
    ProductService productService;

    public void createCart(String shoppingCartID){
        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartID);
        shoppingCartDAO.save(shoppingCart);
    }

    public void removeCart(String shoppingCartID){
        shoppingCartDAO.remove(shoppingCartID);
    }

    public void addToCart(String shoppingCartID, CartLine cartLine){
        ShoppingCart shoppingCart = shoppingCartDAO.find(shoppingCartID);
        shoppingCart.addCartLine(cartLine);
        shoppingCartDAO.save(shoppingCart);

        Product product = cartLine.getProduct();
        product.setQuantityAvailable(product.getQuantityAvailable() - cartLine.getQuantity());
        productService.saveProduct(product);

    }

    public void removeFromCart(String shoppingCartID, String name){
        ShoppingCart shoppingCart = shoppingCartDAO.find(shoppingCartID);
        shoppingCart.getCartLines().removeIf(cartLine -> cartLine.getProduct().getName().equals("name"));
    }

    public void changeQuantity(String shoppingCartID, String name, int quantity){
        ShoppingCart shoppingCart = shoppingCartDAO.find(shoppingCartID);
        for(CartLine cartLine: shoppingCart.getCartLines()){
            if(cartLine.getProduct().getName().equals(name)){
                int prevQuantity = cartLine.getQuantity();
                cartLine.setQuantity(quantity);

                Product product = cartLine.getProduct();
                product.setQuantityAvailable(product.getQuantityAvailable() + prevQuantity - cartLine.getQuantity());
                productService.saveProduct(product);
            }
        }
        shoppingCartDAO.save(shoppingCart);
    }

    public ShoppingCart getShoppingCart(String shoppingCartID){
        return shoppingCartDAO.find(shoppingCartID);
    }

}
