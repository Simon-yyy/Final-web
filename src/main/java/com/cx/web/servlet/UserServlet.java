package com.cx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.cx.pojo.User;
import com.cx.service.UserService;
import com.cx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    //多态的形式,如果实现类发生改变,直接换实现类即可,减少耦合性
    private UserService userService=new UserServiceImpl();

    public void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用方法,查询所有用户
        List<User> users = userService.selectAllUsers();

        //2.转为JSON字符串
        String jsonString= JSON.toJSONString(users);

        //3.写数据到前端处理
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    /**
     * 添加用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
