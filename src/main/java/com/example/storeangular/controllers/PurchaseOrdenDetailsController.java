package com.example.storeangular.controllers;


import com.example.storeangular.DTOs.PurchaseOrderDetailsDTO;
import com.example.storeangular.entities.Product;
import com.example.storeangular.entities.PurchaseOrder;
import com.example.storeangular.entities.PurchaseOrderDetail;
import com.example.storeangular.entities.User;
import com.example.storeangular.repositories.ProductsRepository;
import com.example.storeangular.repositories.PurchaseOrderDetailsRepository;
import com.example.storeangular.repositories.PurchaseOrderRepository;
import com.example.storeangular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/purchaseOrderDetails")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseOrdenDetailsController {

    @Autowired
    private PurchaseOrderDetailsRepository poDetailRepository;
    @Autowired
    private PurchaseOrderRepository poRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @PutMapping(path = "/addPurchaseOrderDetails")
    public void addPurchaseOrderDetails(@RequestParam Integer userID,
                                        @RequestBody PurchaseOrderDetailsDTO poDetailsDTO){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        PurchaseOrder po = poRepository.findTopByUserOrderByOrderDateDesc(user);
        Product product = productsRepository.findById(poDetailsDTO.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        PurchaseOrderDetail poDetail = new PurchaseOrderDetail();
        poDetail.setPurchaseOrder(po);
        poDetail.setProduct(product);
        poDetail.setQuantity(poDetailsDTO.getQuantity());
        poDetail.setPrice(poDetailsDTO.getPrice());

        poDetailRepository.save(poDetail);
    }

    @GetMapping(path = "/getPurchaseOrderDetailsByPO_id")
    public List<PurchaseOrderDetailsDTO> getPurchaseOrderDetailsByPO_id(@RequestParam Integer purchase_order_id){
        PurchaseOrder po = poRepository.findById(purchase_order_id)
                .orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));

        List<PurchaseOrderDetailsDTO> poDTOList = new ArrayList<>();
        poDetailRepository.getPurchaseOrderDetailsByPurchaseOrder(po).forEach(poDetail ->
                poDTOList.add( new PurchaseOrderDetailsDTO(poDetail) )
        );

        return poDTOList;
    }
}
