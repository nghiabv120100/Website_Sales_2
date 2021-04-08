package com.website.service;

import com.website.dao.BrandDAO;
import com.website.models.BrandEntity;

import java.util.List;

public class BrandService  {
    BrandDAO brandDAO = new BrandDAO();

    public List<BrandEntity> findAll() {
        return brandDAO.findAll();
    }
}
