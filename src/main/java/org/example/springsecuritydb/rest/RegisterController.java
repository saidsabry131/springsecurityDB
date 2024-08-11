package org.example.springsecuritydb.rest;


import org.example.springsecuritydb.entity.MyUser;
import org.example.springsecuritydb.service.MyUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final MyUserServiceImp userServiceImp;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegisterController(MyUserServiceImp userServiceImp, PasswordEncoder passwordEncoder) {
        this.userServiceImp = userServiceImp;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign up")
    MyUser getSignUp(@RequestBody MyUser user)
    {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userServiceImp.save(user);
    }

    @PostMapping("/h")
    String hh()
    {
        return "hhh";
    }

    @GetMapping("/hello")
    String say()
    {
        return "HELLO";
    }
}
