package com.cx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 数据库连接池工具类
 */
public class SqlSessionFactoryUtils {
    //局部变量
    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtils() {
    }

    static {
        //静态代码块会随着雷的加载而自动执行,且只执行一次

        try {
            //3. 调用Mybatis完成查询, 根据用户账号查找对象
            //3.1 获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;

    }
}
