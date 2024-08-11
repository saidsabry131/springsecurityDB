package org.example.springsecuritydb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homee")
public class HomeRest {

    @GetMapping("/hello")
    String sayHello()
    {
        return "<h1>welcome </h1>";
    }

    @GetMapping("/{user}")
    String sayHelloUser(@PathVariable String user)
    {
        return "<h1>welcome "+user+"</h1>";
    }
}
