package org.example.springsecuritydb.rest;

import org.example.springsecuritydb.entity.MyUser;
import org.example.springsecuritydb.service.MyUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/// user access and admin
@RestController
@RequestMapping("/api")
public class CrudRest {
    private final MyUserServiceImp userServiceImp;
    @Autowired
    public CrudRest(MyUserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/users")
    List<MyUser> getALLUser()
    {
        return userServiceImp.findAll();
    }

    @GetMapping("/users/{username}")
    MyUser getUser(@PathVariable String username)
    {
        return userServiceImp.getuser(username);
    }

    @PutMapping("/users")

    MyUser updateUser(@RequestBody MyUser user)
    {
       return userServiceImp.update(user);
    }

    @DeleteMapping("/users/{username}")
    ResponseEntity<String> deleteUser(@PathVariable String username)
    {
        MyUser user=userServiceImp.delete(username);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
        } else {
            // If user is not found, return a custom HTML page
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. <a href='/'>Go to Home</a>");
        }

    }
}
