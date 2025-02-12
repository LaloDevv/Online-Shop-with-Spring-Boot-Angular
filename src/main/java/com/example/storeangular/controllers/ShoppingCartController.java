package com.example.storeangular.controllers;

import com.example.storeangular.DTOs.ShoppingCartDTO;
import com.example.storeangular.entities.ShoppingCart;
import com.example.storeangular.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping(path = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository sCharRepository;
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(path = "/all")
    public List<ShoppingCartDTO> getAll(){
        List<ShoppingCartDTO> scDTOlist = new ArrayList<>();
        sCharRepository.findAll().forEach(shoppingCart ->
                scDTOlist.add( new ShoppingCartDTO(shoppingCart) )
        );
        return scDTOlist;
    }




}
