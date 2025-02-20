package com.example.storeangular.repositories;

import com.example.storeangular.entities.PurchaseOrder;
import com.example.storeangular.entities.PurchaseOrderDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseOrderDetailsRepository extends CrudRepository<PurchaseOrderDetail, Integer> {
    List<PurchaseOrderDetail> getPurchaseOrderDetailsByPurchaseOrder(PurchaseOrder purchaseOrder);
}
