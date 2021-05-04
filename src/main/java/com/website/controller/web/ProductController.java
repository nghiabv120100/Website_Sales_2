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

        Long totalpage;
        Long totalProduct = productService.totalProduct();

        if (totalProduct % pageSize == 0){
            totalpage = totalProduct / pageSize;
            System.out.println(totalpage);
        } else {
            totalpage = totalProduct / pageSize + 1;
            System.out.println(totalpage);
        }

        if (type.equals("list")) {
/*            List<ProductEntity> lstProduct = productService.findAll();*/
            List<ProductEntity> lstProduct = null;
            numberpage  = Integer.parseInt(req.getParameter("page"));
            lstProduct = productService.getProductEntity((numberpage - 1) * pageSize, pageSize);
            List<CategoryEntity> lstCategory = categoryService.findAll();
            List<BrandEntity> lstBrand = brandService.findAll();
            req.setAttribute("lstProduct",lstProduct);
            req.setAttribute("lstCategory",lstCategory);
            req.setAttribute("lstBrand",lstBrand);
            req.setAttribute("numOfPages",totalpage);
            req.setAttribute("nextPages",numberpage + 1);
            req.setAttribute("lastPages", numberpage - 1);
            url ="views/web/shop.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
