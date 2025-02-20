package com.example.storeangular.repositories;

import com.example.storeangular.entities.PurchaseOrder;
import com.example.storeangular.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer>{
    PurchaseOrder findTopByUserOrderByOrderDateDesc(User user);
    List<PurchaseOrder> getPurchaseOrdersByUser(User user);
}
