package com.cx.mapper;

import com.cx.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from tb_user;")
    List<User> selectAllUsers();



}
