package com.website.service;

import com.website.dao.CommentDAO;
import com.website.models.CommentEntity;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();
    public void save(CommentEntity comment) {
        commentDAO.save(comment);
    }
}
