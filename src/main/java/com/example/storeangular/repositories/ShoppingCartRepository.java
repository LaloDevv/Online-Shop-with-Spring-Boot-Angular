package com.example.storeangular.repositories;

import com.example.storeangular.entities.ShoppingCart;
import com.example.storeangular.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {
    List<ShoppingCart> getShoppingCartsByUser(User user);
}
