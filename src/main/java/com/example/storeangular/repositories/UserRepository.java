package com.example.storeangular.repositories;

import com.example.storeangular.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
}
