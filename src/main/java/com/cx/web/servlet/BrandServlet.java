package com.cx.web.servlet;

import com.alibaba.fastjson.JSON;
import com.cx.pojo.Brand;
import com.cx.pojo.PageBean;
import com.cx.service.BrandService;
import com.cx.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    //多态的形式,如果实现类发生改变,直接换实现类即可,减少耦合性
    private BrandService brandService=new BrandServiceImpl();

    /**
     * 查询全部数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用service查询
        List<Brand> brands=brandService.selectAll();


        //2.转为JSON字符串
        String jsonString= JSON.toJSONString(brands);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }


    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收品牌数据
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service方法添加
        brandService.add(brand);

        //3.响应添加成功的标识
        response.getWriter().write("addSuccess");

    }


    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收  [1,2,3...]
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //转为  int[]
        int[] ids = JSON.parseObject(params, int[].class);

        //2.调用service方法添加
        brandService.deleteByIds(ids);

        //3.响应添加成功的标识
        response.getWriter().write("deleteSuccess");

    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收 当前页码 和 每页展示条数    通过  url?currentPage=1&pageSize=5  的形式传过来
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2.调用service查询,将查询结果封装为pageBean对象
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);


        //3.pageBean对象转为JSON字符串 传回给页面
        String jsonString= JSON.toJSONString(pageBean);

        //4.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收 当前页码 和 每页展示条数    通过  url?currentPage=1&pageSize=5  的形式传过来
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //转为  Brand
        Brand brand = JSON.parseObject(params, Brand.class);


        //2.调用service查询,将查询结果封装为pageBean对象
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        //3.pageBean对象转为JSON字符串 传回给页面
        String jsonString= JSON.toJSONString(pageBean);

        //4.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    /**
     * 根据id删除对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteBrandById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //将接收过来的id转为int型
        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);


        //2.调用service方法添加
        brandService.deleteBrandById(id);

        //3.响应添加成功的标识
        response.getWriter().write("deleteSuccess");

    }


    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //1.接收修改后的品牌数据
        BufferedReader br = request.getReader();
        String params=br.readLine();  //json字符串

        //将接收过来的id转为int型
        String _id=request.getParameter("id");
        int id=Integer.parseInt(_id);

        //将接收过来的JSON数据e对象,转为Brand对象
        Brand _brand = JSON.parseObject(params, Brand.class);

        //将需要修改的内容封装为一个brand对象
        Brand brand=new Brand();
        brand.setId(id);
        brand.setBrandName(_brand.getBrandName());
        brand.setCompanyName(_brand.getCompanyName());
        brand.setOrdered(_brand.getOrdered());
        brand.setDescription(_brand.getDescription());
        brand.setStatus(_brand.getStatus());

        //2.调用service方法进行修改
        brandService.update(brand);

        //3.响应修改成功的标识
        response.getWriter().write("updateSuccess");

    }

}
