package com.website.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.Cons.VerificationCodes;
import com.website.models.DetailCategoryEntity;
import com.website.models.ProductEntity;
import com.website.models.UserEntity;
import com.website.service.DetailCategoryService;
import com.website.service.ProductService;
import com.website.service.UserService;
import com.website.utils.HttpUtil;
import com.website.utils.JavaMailUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
    ProductService productService = new ProductService();
    UserService userService = new UserService();

    String url="";
    List<ProductEntity> lstMSI;
    List<ProductEntity> lstACER;
    List<ProductEntity> lstASUS;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        url="views/web/index.jsp";
        List<ProductEntity> lstProduct = productService.findAll();

        lstMSI = new ArrayList<>();
        lstACER = new ArrayList<>();
        lstASUS = new ArrayList<>();

        for (int i=0;i<lstProduct.size();i++) {
            if (lstProduct.get(i).getDetailCategoryEntity().getId()==1) {
                if(lstACER.size() <3) {
                    lstACER.add(lstProduct.get(i));
                }

            } else if (lstProduct.get(i).getDetailCategoryEntity().getId()==7) {
                if (lstASUS.size() < 3)
                    lstASUS.add(lstProduct.get(i));
            } else if (lstProduct.get(i).getDetailCategoryEntity().getId()==10) {
                if (lstMSI.size() < 3)
                    lstMSI.add(lstProduct.get(i));
            }
        }

        req.setAttribute("lstACER",lstACER);
        req.setAttribute("lstMSI",lstMSI);
        req.setAttribute("lstASUS",lstASUS);
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =req.getParameter("emailReset");
        String username= req.getParameter("userName");
        String msg="";
        UserEntity accountModel=null;
        if (email == null)
        {
            msg="Vui l??ng nh???p email";
        }
        else {
            accountModel = userService.findByUserName(username);

//            accountModel = accountService.getUser(email);
            if (accountModel == null ) {
                msg="T??i kho???n kh??ng t???n t???i";
            } else if (!accountModel.getEmail().equals(email)) {
                msg="Email kh??ng ch??nh x??c";
            } else {
                Random random = new Random();
                Integer pass = random.nextInt(899999) + 100000;
                VerificationCodes.code = pass;
                VerificationCodes.username=username;
//                accountModel.setPassWord(pass.toString());
//                userService.update(accountModel);
                String content = "M?? x??c th???c c???a b???n l??: " + pass;
                try {
                    JavaMailUtil.sendMail(email, "L???y l???i m???t kh???u", content);
                    msg = "M?? x??c nh???n ???? ???????c g???i v??o gmail c???a b???n.";
                } catch (Exception e) {
                    msg = "Thao t??c th???t b???i, vui l??ng th??? l???i.";
                    e.printStackTrace();
                }
            }
        }

        req.setAttribute("email",email);
        req.setAttribute("username",username);
        req.setAttribute("msg",msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Reset password
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
        String code = req.getParameter("code");
        if (userEntity != null && code != null) {
            if (!userEntity.getUsername().equals(VerificationCodes.username) || !code.trim().equals(VerificationCodes.code.toString())) {
                return;
            }
            UserEntity user = userService.findByUserName(userEntity.getUsername());
            user.setPassWord(userEntity.getPassWord());
            userService.update(user);
            mapper.writeValue(resp.getOutputStream(),1);
        }
        mapper.writeValue(resp.getOutputStream(),null);
    }
}
