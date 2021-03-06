package com.website.controller.web;

import com.website.models.CartEntity;
import com.website.models.Product_Cart_Entity;
import com.website.models.UserEntity;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@WebServlet(urlPatterns= {"/payment"})
public class PaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("isOnline","True");
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        CartEntity cartEntity =  (CartEntity) session.getAttribute("order");
        cartEntity.setClientEntity(userEntity);
        cartEntity.setPayments(1);
        if(cartEntity !=null){

            String chuoi="";
            chuoi+="upload=1";
            chuoi+="&&return=http://localhost:8080/Website_Sales_2_war_exploded/api-user-order";
            chuoi+="&&cmd=_cart";
            chuoi+="&&business=chuShop@gmail.com";

            int i=1;

            for(Product_Cart_Entity cartItemModel : cartEntity.getProductCartEntityList()){
                chuoi+=removeAccent("&&item_name_"+i+"="+cartItemModel.getProductEntity().getProName());
                chuoi+="&&quantity_"+i+"="+cartItemModel.getQuantity();
                chuoi+="&&amount_"+i+"="+(cartItemModel.getUnitPrice()/24000);
                i++;
            }

            resp.sendRedirect("https://www.sandbox.paypal.com/cgi-bin/webscr?"+chuoi);
        }
        else
        {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/paySuccess");
            dispatcher.forward(req, resp);
        }
    }

    private static final char[] SOURCE_CHARACTERS = {'??', '??', '??', '??', '??', '??',
            '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??',
            '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??',
            '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '??', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???', '???',
            '???', '???', '???',};

    private static final char[] DESTINATION_CHARACTERS = {'A', 'A', 'A', 'A', 'E',
            'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
            'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
            'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
            'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u',};

    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    public static String removeAccent(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }
}

