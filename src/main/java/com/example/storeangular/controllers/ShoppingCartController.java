package com.example.storeangular.controllers;

import com.example.storeangular.entities.ShoppingCart;
import com.example.storeangular.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository sCharRepository;
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(path = "/all")
    public List<ShoppingCart> getAll(){
        return (List<ShoppingCart>) sCharRepository.findAll();
    }


}
