package com.website.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.dao.DetailCategoryDAO;
import com.website.models.DetailCategoryEntity;
import com.website.utils.HttpUtil;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-detailcategory"})
public class DetailCategoryAPI extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DetailCategoryDAO detailCategoryDAO = new DetailCategoryDAO();

        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model

        DetailCategoryEntity detailCategoryEntity = HttpUtil.of(req.getReader()).toModel(DetailCategoryEntity.class);

        detailCategoryDAO.save(detailCategoryEntity);
        mapper.writeValue(resp.getOutputStream(),detailCategoryEntity);
    }
}
