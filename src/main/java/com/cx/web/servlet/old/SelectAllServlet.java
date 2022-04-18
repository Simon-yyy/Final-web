package com.cx.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.cx.pojo.Brand;
import com.cx.service.BrandService;
import com.cx.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    //多态的形式,如果实现类发生改变,直接换实现类即可,减少耦合性
    private BrandService brandService=new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands=brandService.selectAll();


        //2.转为JSON字符串
        String jsonString= JSON.toJSONString(brands);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
