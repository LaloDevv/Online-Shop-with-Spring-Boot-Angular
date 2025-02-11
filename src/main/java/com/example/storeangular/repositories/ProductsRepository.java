package com.example.storeangular.repositories;

import com.example.storeangular.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Integer> {

}
