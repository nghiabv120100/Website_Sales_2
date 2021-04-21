package com.website.controller.admin;

import com.website.models.GoodsReceivedEntity;
import com.website.models.SupplierEntity;
import com.website.service.SupplierService;
import com.website.service.Warehouse_ReceiptService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin-warehouse_receipt-list")
public class Warehouse_ReceiptController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Warehouse_ReceiptService warehouse_receiptService = new Warehouse_ReceiptService();
        SupplierService supplierService = new SupplierService();
        String url = "";
        String type=request.getParameter("type");
        if(type.equals("list")){
            ServletContext application=getServletConfig().getServletContext();
            List<GoodsReceivedEntity> goodsReceivedEntityList = warehouse_receiptService.findAll();
            request.setAttribute("lstGoodsReceived", goodsReceivedEntityList);
            url="views/admin/view/list-warehouse_receipt.jsp";
        } else if (type.equals("add")){
            List<SupplierEntity> supplierEntityList = supplierService.findAll();
            request.setAttribute("lstSupplier",supplierEntityList);
            url ="views/admin/view/add-warehouse_receipt.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request,response);
    }
}
