package org.example.springsecuritydb.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import org.example.springsecuritydb.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MyUserImp implements MyUserDao{

    private EntityManager entityManager;
   // private final PasswordEncoder passwordEncoder;
    @Autowired
    public MyUserImp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
       // this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public MyUser saveUser(MyUser user) {

       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getRole()==null || user.getRole().equals(""))
        {
            user.setRole("USER");
        }
        entityManager.persist(user);
        return user;

    }


    @Override
    public List<MyUser> getAll() {
        TypedQuery<MyUser> query= entityManager.createQuery("from MyUser ",MyUser.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public MyUser deleteUser(String username) {
        MyUser user=entityManager.find(MyUser.class,username);
        entityManager.remove(user);
        return user;
    }

    @Transactional
    @Override
    public MyUser updateUser(MyUser myUser) {
        MyUser user=entityManager.find(MyUser.class,myUser.getUsername());

        if(user!=null) {
            return entityManager.merge(myUser);
        }
        else
        {
            throw new EntityNotFoundException("User not found: " + myUser.getUsername());

        }
    }

    @Override
    public MyUser getByUsername(String username) {
        return entityManager.find(MyUser.class,username);
    }
}
