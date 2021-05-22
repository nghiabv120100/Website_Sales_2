package com.website.controller.admin;

import com.google.gson.Gson;
import com.website.models.GoodsReceivedEntity;
import com.website.models.Product_GoodReceived_Entity;
import com.website.utils.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/add_pro_good"})
public class AddProGoodController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GoodsReceivedEntity goodsReceivedEntity = (GoodsReceivedEntity) session.getAttribute("ss_GoodsReceived");
        Product_GoodReceived_Entity product_goodReceived_entity = HttpUtil.of(req.getReader()).toModel(Product_GoodReceived_Entity.class);
        int id = product_goodReceived_entity.getProductEntity().getId();
        int quantity = product_goodReceived_entity.getQuantity();
        List<Product_GoodReceived_Entity> lst_pro = goodsReceivedEntity.getProductGoodReceivedEntityList();
        if (lst_pro.size() == 0){
            lst_pro.add(product_goodReceived_entity);
        } else {
            boolean check=false;
            for(Product_GoodReceived_Entity item : lst_pro) {
                if (item.getProductEntity().getId() == id){
                    item.setQuantity(item.getQuantity()+quantity);
                    check=true;
                }
            }
            if (check==false) {
                lst_pro.add(product_goodReceived_entity);
            }
        }
        goodsReceivedEntity.setProductGoodReceivedEntityList(lst_pro);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String hangnhap = new Gson().toJson(product_goodReceived_entity);
        resp.getWriter().write(hangnhap);
    }
}
