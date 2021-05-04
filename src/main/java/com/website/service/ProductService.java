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
    public ProductEntity findById(int id) {
        return productDAO.findById(id);
    }

    public ProductEntity update(ProductEntity product) {
        return productDAO.update(product);
    }
    public int delete(Integer id) {
        ProductEntity product = findById(id);
        product.setStatus(0);
        return productDAO.delete(product);
    }

    public List<ProductEntity> getProductEntity(int brand_id,int detail_cate_id,int start_price,int end_price,int postiton, int pageSize){
        return productDAO.getProductEntity(brand_id,detail_cate_id,start_price,end_price,postiton,pageSize);
    }

    public Long totalProduct(){
        return productDAO.countTotalProduct();
    }
}
