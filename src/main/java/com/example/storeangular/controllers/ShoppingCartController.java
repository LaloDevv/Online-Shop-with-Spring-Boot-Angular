package com.example.storeangular.controllers;

import com.example.storeangular.DTOs.ShoppingCartDTO;
import com.example.storeangular.entities.Product;
import com.example.storeangular.entities.ShoppingCart;
import com.example.storeangular.entities.ShoppingCartId;
import com.example.storeangular.entities.User;
import com.example.storeangular.repositories.ProductsRepository;
import com.example.storeangular.repositories.ShoppingCartRepository;
import com.example.storeangular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/shoppingCart")
@CrossOrigin(origins = "http://localhost:4200")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository sCharRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping(path = "/allById")
    public List<ShoppingCartDTO> getShoppingCartById(@RequestParam Integer userID){
        List<ShoppingCartDTO> scDTOlist = new ArrayList<>();
        Optional<User> user = userRepository.findById(userID);

        sCharRepository.getShoppingCartsByUser(user).forEach( shoppingCart ->
            scDTOlist.add(new ShoppingCartDTO(shoppingCart))
        );
        return scDTOlist;
    }

    @PutMapping(path = "/addToShoppingCart")
    public void addToShoppingCartPUT(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCartId ident = new ShoppingCartId();
        ident.setProductId(shoppingCartDTO.getProductID());
        ident.setUserId(shoppingCartDTO.getUserID());

        ShoppingCart actualShoppingCart = sCharRepository.getShoppingCartById(ident);

        if (actualShoppingCart != null) {
            actualShoppingCart.setQuantity(actualShoppingCart.getQuantity() + 1);
            sCharRepository.save(actualShoppingCart);
        } else {
            ShoppingCart sc = new ShoppingCart();
            sc.setId(ident);
            sc.setQuantity(1);
            sc.setPrice(shoppingCartDTO.getPrice());

            Product product = productsRepository.findById(shoppingCartDTO.getProductID())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            sc.setProduct(product);

            User user = userRepository.findById(shoppingCartDTO.getUserID())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            sc.setUser(user);

            sCharRepository.save(sc);
        }
    }

    @DeleteMapping(path = "/deleteItemShoppingCart")
    public void deleteItemShoppingCart(@RequestBody ShoppingCartDTO sc){
        ShoppingCartId scID = new ShoppingCartId();
        scID.setUserId(sc.getUserID());
        scID.setProductId(sc.getProductID());
        ShoppingCart scToDelete = sCharRepository.getShoppingCartById(scID);
        sCharRepository.delete(scToDelete);
    }
}
