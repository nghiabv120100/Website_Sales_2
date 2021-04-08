package com.website.service;

import com.website.dao.DetailCategoryDAO;
import com.website.models.DetailCategoryEntity;

import java.util.List;

public class DetailCategoryService {
    private DetailCategoryDAO detailCategoryDAO = new DetailCategoryDAO();
    public List<DetailCategoryEntity> findAll() {
        return detailCategoryDAO.findAll();
    }
}
