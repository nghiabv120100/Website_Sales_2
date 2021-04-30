package com.website.service;

import com.website.dao.ImportGoodsDAO;
import com.website.models.ImportGoodsEntity;
import com.website.models.ProductEntity;

public class ImportGoodsService {
    private ImportGoodsDAO importGoodsDAO = new ImportGoodsDAO();
    public void save(ImportGoodsEntity importGoodsEntity){
        importGoodsDAO.save(importGoodsEntity);
    }
    public int delete(int id){
        return importGoodsDAO.delete(id);
    }
}
