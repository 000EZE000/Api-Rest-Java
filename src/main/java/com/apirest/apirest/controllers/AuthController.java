package com.apirest.apirest.controllers;

import com.apirest.apirest.models.Login;
import com.apirest.apirest.services.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/auth/")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    ServicesUser servicesUser;

    @PostMapping("login")
    public String login(@RequestBody Login login){
        return servicesUser.checkPasswordAndEmail(login);
    }
}
