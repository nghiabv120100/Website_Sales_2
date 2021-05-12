package com.website.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.service.CartService;
import com.website.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-user-order"})
public class OrderAPI extends HttpServlet {
    private UserService userService = new UserService();
    private CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession();
        CartEntity cartEntity=(CartEntity) session.getAttribute("order");
        String isOnline =(String) session.getAttribute("isOnline");
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (cartEntity != null) {
            cartService.save(cartEntity);

            if (isOnline !=null) {
                resp.sendRedirect(req.getContextPath()+"/paySuccess");
            } else {
                mapper.writeValue(resp.getOutputStream(),1);
            }
            System.out.println("Mua hang thanh cong");
        }
    }
}
