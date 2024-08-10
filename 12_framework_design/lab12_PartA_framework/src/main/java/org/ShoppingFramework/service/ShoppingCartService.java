package org.ShoppingFramework.service;


import org.ShoppingFramework.dao.ShoppingCartDAO;
import org.ShoppingFramework.domain.CartLine;
import org.ShoppingFramework.domain.Product;
import org.ShoppingFramework.domain.ShoppingCart;

public class ShoppingCartService {
    ShoppingCartDAO shoppingCartDAO;
    ProductService productService;

    public ShoppingCartService(){
        shoppingCartDAO = new ShoppingCartDAO();
        productService = new ProductService();
    }

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
