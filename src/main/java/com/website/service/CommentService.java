package com.website.service;

import com.website.dao.CommentDAO;
import com.website.models.CommentEntity;

import java.util.List;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();
    public void save(CommentEntity comment) {
        commentDAO.save(comment);
    }
    public List<CommentEntity> findAll() {
        return commentDAO.findAll();
    }
}
