package org.example.springsecuritydb.service;

import org.example.springsecuritydb.entity.MyUser;
import org.example.springsecuritydb.service.MyUserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {
    private MyUserServiceDao myUserServiceDao;

    @Autowired
   public MyUserDetails(MyUserServiceDao myUserServiceDao)
    {
        this.myUserServiceDao=myUserServiceDao;

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser= myUserServiceDao.getuser(username);// get user from database

        if(myUser!=null)
        {

             return User.builder() // set userDetails
                    .username(myUser.getUsername())
                    .password(myUser.getPassword())
                    .roles(getRoles(myUser))
                    .build();


        }
        else {
            throw new UsernameNotFoundException("User not found: " + username);

        }
    }

    // split role s thst come from database

    private String[] getRoles(MyUser user)
    {
        if(user.getRole()==null)
        {
            user.setRole("USER");
            return new String[]{"USER"};

        }
        else{
            return user.getRole().split(",");
        }
    }

}
