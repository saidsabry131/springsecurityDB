package org.example.springsecuritydb.dao;

import org.example.springsecuritydb.entity.MyUser;

import java.util.List;

public interface MyUserDao {

    MyUser saveUser(MyUser user);
    List<MyUser> getAll();

    MyUser deleteUser(String username);

    MyUser updateUser(MyUser user);

    MyUser getByUsername(String username);
}
