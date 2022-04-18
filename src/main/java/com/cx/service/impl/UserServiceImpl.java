package com.cx.service.impl;

import com.cx.mapper.UserMapper;
import com.cx.pojo.User;
import com.cx.service.UserService;
import com.cx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    //1.创建SqlSessionFactory工厂对象
    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<User> selectAllUsers() {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        List<User> users = mapper.selectAllUsers();

        //释放资源
        sqlSession.close();

        return users;

    }


}
