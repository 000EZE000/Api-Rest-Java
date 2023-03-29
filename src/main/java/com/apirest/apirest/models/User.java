package com.apirest.apirest.models;


import jakarta.persistence.*;
import lombok.*;


@ToString @EqualsAndHashCode
@Getter @Setter
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name ="last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private int phone;

    public User(long id, String name, String lastName, String email, String password, int phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public  User(){}
}
