package com.website.controller.admin;

import com.website.models.ProductEntity;
import com.website.service.ProductService;
import org.hibernate.service.spi.InjectService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-product-list"})
public class ProductController extends HttpServlet {
//    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductService();
        String url="";
        String type=req.getParameter("type");
        if (type.equals("list")) {
            List<ProductEntity> lstProduct =productService.findAll();
            req.setAttribute("lstProduct",lstProduct);
            url ="views/admin/view/list-product.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
