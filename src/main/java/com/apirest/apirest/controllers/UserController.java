package com.apirest.apirest.controllers;
import com.apirest.apirest.models.User;
import com.apirest.apirest.services.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/users/")
@CrossOrigin("*")
public class UserController {


    @Autowired
    ServicesUser servicesUser;
    @GetMapping("id/{id}")
    public User getUserByID(@PathVariable long id){
    User user =  new User();
    return  user;
    }


    @GetMapping("all")
    public  List<User> getUsers(){
        return servicesUser.getAllUser();
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable String id  ){
        long idLong = Long.parseLong(id );
        servicesUser.deleteUser(idLong);
        return  "OK";
    }

    @PostMapping("create")
        public void registerUser(@RequestBody User user){
            servicesUser.registerUser(user);
    }


}
