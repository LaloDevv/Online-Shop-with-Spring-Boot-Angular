package com.example.storeangular.controllers;

import com.example.storeangular.entities.Product;
import com.example.storeangular.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(path = "/all")
    public Iterable<Product> getAllProducts(){
        return productsRepository.findAll();
    }

    @GetMapping(path = "/getProductById")
    public Optional<Product> getProductById(@RequestParam Integer id){
        return productsRepository.findById(id);
    }

}
