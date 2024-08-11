package org.example.springsecuritydb.service;

import org.example.springsecuritydb.dao.MyUserImp;
import org.example.springsecuritydb.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImp implements MyUserServiceDao{
    private MyUserImp myUserImp;


    @Autowired
    public MyUserServiceImp(MyUserImp myUserImp)
    {
        this.myUserImp=myUserImp;

    }
    @Override
    public MyUser save(MyUser user) {

        return myUserImp.saveUser(user);
    }

    @Override
    public List<MyUser> findAll() {
        return myUserImp.getAll();
    }

    @Override
    public MyUser delete(String username) {
        return myUserImp.deleteUser(username);
    }

    @Override
    public MyUser update(MyUser user) {
        return myUserImp.updateUser(user);
    }

    @Override
    public MyUser getuser(String username) {
        return myUserImp.getByUsername(username);
    }
}
