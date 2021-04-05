package com.website.service;

import com.website.dao.ProductDAO;
import com.website.models.ProductEntity;

import javax.inject.Inject;
import java.util.List;

public class ProductService {
//    @Inject
    private ProductDAO productDAO = new ProductDAO();

    public List<ProductEntity> findAll() {
        return productDAO.findAll();
    }
    public void save(ProductEntity product) {
        productDAO.save(product);
    }
}
