package com.website.controller.admin.api;

import com.website.models.SupplierEntity;
import com.website.models.UserEntity;
import com.website.service.UserService;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserEntity userEntity = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
        userService.save(userEntity);
        mapper.writeValue(resp.getOutputStream(),1);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserEntity newUserEntity = HttpUtil.of(req.getReader()).toModel(UserEntity.class);

        UserEntity user = userService.update(newUserEntity);

        mapper.writeValue(resp.getOutputStream(),user);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        Integer id = Integer.parseInt(req.getReader().readLine());
        int result = userService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
