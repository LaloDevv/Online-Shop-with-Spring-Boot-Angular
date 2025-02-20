package com.example.storeangular.repositories;

import com.example.storeangular.entities.ShoppingCart;
import com.example.storeangular.entities.ShoppingCartId;
import com.example.storeangular.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {
    List<ShoppingCart> getShoppingCartsByUser(Optional<User> user);

    ShoppingCart getShoppingCartById(ShoppingCartId id);
}
