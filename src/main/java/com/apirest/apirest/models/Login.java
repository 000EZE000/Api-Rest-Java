package com.apirest.apirest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Login {
    private String email;
    private String password;

    public  Login(){}

}
