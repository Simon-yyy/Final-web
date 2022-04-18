package com.cx.service.impl;

import com.cx.mapper.BrandMapper;
import com.cx.pojo.Brand;
import com.cx.pojo.PageBean;
import com.cx.service.BrandService;
import com.cx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * BrandService实现类
 */
public class BrandServiceImpl implements BrandService {

    //1.创建SqlSessionFactory工厂对象
    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        List<Brand> brands=mapper.selectAll();

        //5.释放资源
        sqlSession.close();

        return brands;
    }

    /**
     * 添加数据
     * @param brand 品牌
     */
    @Override
    public void add(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 修改数据
     * @param brand 品牌
     */
    @Override
    public void update(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        mapper.update(brand);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        mapper.deleteByIds(ids);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();


    }

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;
        //5.计算查询条目数
        int size=pageSize;

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Brand> rows = mapper.selectByPage(begin, size);

        //7.查询总记录数
        int totalCount=mapper.selectTotalCount();

        //8.封装PageBean对象
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9.释放资源
        sqlSession.close();

        return pageBean;

    }

    /**
     * 动态分页查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
        int begin=(currentPage-1)*pageSize;
        //5.计算查询条目数
        int size=pageSize;

        //处理brand条件,模糊表达式
        String brandName = brand.getBrandName();
        if(brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }

        String companyName = brand.getCompanyName();
        if(companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }

        //6.查询当前页数据    limit 开始索引位置,每页显示条数   -->  获取到的就是当前页的数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size,brand);

        //7.查询总记录数
        int totalCount=mapper.selectTotalCountByCondition(brand);

        //8.封装PageBean对象
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //9.释放资源
        sqlSession.close();

        return pageBean;
    }

    /**
     * 根据id删除对象
     * @param id 要删除对象的id
     */
    @Override
    public void deleteBrandById(int id) {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        mapper.deleteBrandById(id);
        //修改后,要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


}
