package com.example.storeangular.controllers;

import com.example.storeangular.entities.Product;
import com.example.storeangular.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(path = "/all")
    public Iterable<Product> getAllProducts(){
        return productsRepository.findAll();
    }

}
