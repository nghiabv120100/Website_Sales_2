package com.website.controller.web;

import com.website.models.DetailCategoryEntity;
import com.website.models.ProductEntity;
import com.website.service.DetailCategoryService;
import com.website.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    ProductService productService = new ProductService();

    String url="";
    List<ProductEntity> lstMSI;
    List<ProductEntity> lstDELL;
    List<ProductEntity> lstASUS;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        url="views/web/index.jsp";
        List<ProductEntity> lstProduct = productService.findAll();

        lstMSI = new ArrayList<>();
        lstDELL = new ArrayList<>();
        lstASUS = new ArrayList<>();

        for (int i=0;i<lstProduct.size();i++) {
            if (lstProduct.get(i).getDetailCategoryEntity().getId()==3) {
                lstDELL.add(lstProduct.get(i));
            } else if (lstProduct.get(i).getDetailCategoryEntity().getId()==2) {
                lstASUS.add(lstProduct.get(i));
            } else if (lstProduct.get(i).getDetailCategoryEntity().getId()==7) {
                lstMSI.add(lstProduct.get(i));
            }
        }

        req.setAttribute("lstDELL",lstDELL);
        req.setAttribute("lstMSI",lstMSI);
        req.setAttribute("lstASUS",lstASUS);
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }

}
