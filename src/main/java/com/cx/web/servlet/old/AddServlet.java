package com.cx.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.cx.pojo.Brand;
import com.cx.service.BrandService;
import com.cx.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    //多态的形式,如果实现类发生改变,直接换实现类即可,减少耦合性
    private BrandService brandService=new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收品牌数据
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service方法添加
        brandService.add(brand);

        //3.响应成功的标识
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
