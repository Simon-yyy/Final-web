package com.cx.service;

import com.cx.pojo.Brand;
import com.cx.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {


    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand 品牌
     */
    void add(Brand brand);

    /**
     * 修改数据
     * @param brand 品牌
     */
    void update(Brand brand);

    /**
     * 完成批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    void deleteBrandById(int id);

}
