package org.example.springsecuritydb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class MyUser {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String password;
    private String role;

}
