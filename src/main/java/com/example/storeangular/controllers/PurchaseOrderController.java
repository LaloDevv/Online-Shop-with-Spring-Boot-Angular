package com.example.storeangular.controllers;

import com.example.storeangular.DTOs.PurchaseOrderDTO;
import com.example.storeangular.entities.PurchaseOrder;
import com.example.storeangular.entities.User;
import com.example.storeangular.repositories.PurchaseOrderRepository;
import com.example.storeangular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/purchaseOrder")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRepository poRepository;
    @Autowired
    private UserRepository userRepository;


    @PutMapping(path = "/addPurchaseOrder")
    public void addPurchaseOrder(@RequestBody PurchaseOrderDTO poDTO){
        PurchaseOrder po = new PurchaseOrder();
        User user = userRepository.findById(poDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        po.setUser(user);
        po.setOrderDate(poDTO.getOrder_date());
        po.setTotalPrice(poDTO.getTotal_price());

        poRepository.save(po);
    }

    @GetMapping(path = "/getPOByUserOrderByOrderDateDesc")
    public PurchaseOrder getPOByUserOrderByOrderDateDesc(@RequestParam Integer userID){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return poRepository.findTopByUserOrderByOrderDateDesc(user);
    }

    @GetMapping(path = "/getPurchasesOrdersByUser")
    public List<PurchaseOrder> getPurchasesOrdersByUser(@RequestParam Integer userID){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return poRepository.getPurchaseOrdersByUser(user);
    }

}
