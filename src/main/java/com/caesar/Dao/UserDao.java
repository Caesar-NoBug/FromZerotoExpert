package com.caesar.Dao;

import com.caesar.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from tbl_user where username = #{username}")
    public User getUserByUsername(String username);

    @Select("insert into tbl_user (id, username, password, sex, age)" +
            " values(null, #{username}, #{password}, #{sex}, #{age})")
    public void insertUser(User user);
}
