package org.example.springsecuritydb.service;

import org.example.springsecuritydb.entity.MyUser;

import java.util.List;

public interface MyUserServiceDao {
    MyUser save(MyUser user);
    List<MyUser> findAll();

    MyUser delete(String username);

    MyUser update(MyUser user);

    MyUser getuser(String username);

}
