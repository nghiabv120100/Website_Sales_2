package com.website.controller.admin;

import com.website.models.CartEntity;
import com.website.service.CartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/admin-order-list"})
public class CartController extends HttpServlet {
    private CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String url ="";
        if (type.equals("list")) {
            List<CartEntity> lstCart = cartService.findAll();
            req.setAttribute("lstCart",lstCart);
            url="views/admin/view/list-order.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);

    }
}
