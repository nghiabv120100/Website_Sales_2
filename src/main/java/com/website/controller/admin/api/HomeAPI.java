package com.website.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.dao.UserDAO;
import com.website.models.UserEntity;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;

@WebServlet(urlPatterns = "/validationlogin")
public class HomeAPI extends HttpServlet {

    String msg;
    private UserDAO loginDao;
    private UserEntity userEntity;
    public void init(){
        loginDao = new UserDAO();
        userEntity = new UserEntity();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userEntity= loginDao.findbyusername_password(username, password);
        if(userEntity != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginname",username);
            if (userEntity.getRole().equals("admin") || userEntity.getRole().equals("employee") || userEntity.getRole().equals("shipper")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/view/index.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            msg="Tên đăng nhập hoặc mật khẩu không chính xác.";
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
