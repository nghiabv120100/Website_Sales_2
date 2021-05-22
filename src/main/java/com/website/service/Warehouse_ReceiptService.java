package com.website.service;

import com.website.dao.Warehouse_ReceiptDAO;
import com.website.models.CartEntity;
import com.website.models.GoodsReceivedEntity;

import java.util.List;

public class Warehouse_ReceiptService {
    private Warehouse_ReceiptDAO warehouse_receiptDAO = new Warehouse_ReceiptDAO();
    public List<GoodsReceivedEntity> findAll(){
        return warehouse_receiptDAO.findAll();
    }
    public void save(GoodsReceivedEntity goodsReceivedEntity) {
        warehouse_receiptDAO.save(goodsReceivedEntity);
    }
}
