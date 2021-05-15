package com.website.controller.web;

import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.service.CartService;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/account-manager"})
public class UserController extends HttpServlet {

    CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url="";
        HttpSession session = req.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        if (user!=null) {
            List<CartEntity> lstCart = cartService.findByUserID(user.getId());
            req.setAttribute("lstCart",lstCart);
            req.setAttribute("user",user);
            url="views/web/checkout.jsp";
        } else {
            url="views/web/login.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
