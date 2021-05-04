package com.website.controller.web;

import com.website.models.BrandEntity;
import com.website.models.CategoryEntity;
import com.website.models.DetailCategoryEntity;
import com.website.models.ProductEntity;
import com.website.service.BrandService;
import com.website.service.CategoryService;
import com.website.service.DetailCategoryService;
import com.website.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/client-product-list"})
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    DetailCategoryService detailCategoryService = new DetailCategoryService();
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String url = "";
        int numberpage = 1;
        int pageSize = 9;
        int category_id = -1;
        int detail_cate_id = -1;
        int start_price = -1;
        int end_price = 900000000;
        int brandId = -1;

        Long totalpage;
        Long totalProduct = productService.totalProduct();
        if (totalProduct % pageSize == 0){
            totalpage = totalProduct / pageSize;
            System.out.println(totalpage);
        } else {
            totalpage = totalProduct / pageSize + 1;
            System.out.println(totalpage);
        }

        //chung
        List<CategoryEntity> lstCategory = categoryService.findAll();
        List<BrandEntity> lstBrand = brandService.findAll();
        List<ProductEntity> lstProduct = null;
        numberpage  = Integer.parseInt(req.getParameter("page"));

        if(numberpage == 1){
            req.setAttribute("lastPages", numberpage);
        } else {
            req.setAttribute("lastPages", numberpage - 1);
        }
        if(numberpage == totalpage){
            req.setAttribute("nextPages",numberpage);
        } else {
            req.setAttribute("nextPages",numberpage + 1);
        }
        req.setAttribute("numOfPages",totalpage);
        req.setAttribute("lstCategory",lstCategory);
        req.setAttribute("lstBrand",lstBrand);

        //theo tung loai
        if (type.equals("list")) {
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";
        } else if(type.equals("detail_category")){
            detail_cate_id = Integer.parseInt(req.getParameter("detail_cate_id"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";
        } else if(type.equals("Price")){
            start_price = Integer.parseInt(req.getParameter("startPrice"));
            end_price = Integer.parseInt(req.getParameter("endPrice"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";
        } else if(type.equals("Brand")){
            brandId = Integer.parseInt(req.getParameter("brand_id"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
