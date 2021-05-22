package com.website.service;

import com.website.dao.GoodReceivedItemDAO;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.Product_GoodReceived_Key;

public class ProductGoodReceivedService {
    GoodReceivedItemDAO goodReceivedItemDAO = new GoodReceivedItemDAO();
    public void save(Product_GoodReceived_Entity product_goodReceived_entity){
        Product_GoodReceived_Key product_goodReceived_key = new Product_GoodReceived_Key(product_goodReceived_entity.getGoodsReceivedEntity().getId(),product_goodReceived_entity.getProductEntity().getId());
        product_goodReceived_entity.setId(product_goodReceived_key);
        goodReceivedItemDAO.save(product_goodReceived_entity);
    }
}
