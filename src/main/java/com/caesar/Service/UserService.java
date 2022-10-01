package com.caesar.Service;

import com.caesar.Dao.UserDao;
import com.caesar.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean register(User user){

        //查询用户名是否存在
        if(userDao.getUserByUsername(user.getUsername()) != null){
            return false;
        }

        userDao.insertUser(user);

        return true;
    }
}
