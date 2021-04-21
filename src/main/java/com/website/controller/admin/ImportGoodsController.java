package com.website.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.website.models.ImportGoodsEntity;
import com.website.models.ProductEntity;
import com.website.service.ImportGoodsService;
import com.website.utils.HttpUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/addImportGoods"})
public class ImportGoodsController extends HttpServlet {

    private ImportGoodsService importGoodsService = new ImportGoodsService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ImportGoodsEntity importGoodsEntity = HttpUtil.of(request.getReader()).toModel(ImportGoodsEntity.class);
        importGoodsService.save(importGoodsEntity);
        mapper.writeValue(response.getOutputStream(),importGoodsEntity);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = req.getParameter("para");
        System.out.println(jsonData);
        int result= importGoodsService.delete(20);
        if(result == 1){
            mapper.writeValue(resp.getOutputStream(),"Xóa thành công");
        } else {
            mapper.writeValue(resp.getOutputStream(),"Xóa thất bại");
        }
    }
}
