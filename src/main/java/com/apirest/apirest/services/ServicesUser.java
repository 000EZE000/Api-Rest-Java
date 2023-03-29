package com.apirest.apirest.services;

import com.apirest.apirest.models.Login;
import com.apirest.apirest.models.User;
import com.apirest.apirest.repositories.RepositoryUserImp;
import com.apirest.apirest.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ServicesUser {

    @Autowired
    RepositoryUserImp repositoryUser;

    @Autowired
    JWTUtil jwtUtil;

    private Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    public List<User> getAllUser() {
        return repositoryUser.allUser();
    }


    public void deleteUser(Long id) {
        repositoryUser.deleteUser(id);
    }

    public void registerUser(User user) {
        String hash = argon2.hash(1, 1024,1,user.getPassword());
        user.setPassword(hash);
        repositoryUser.registerUser(user);
    }

    public User login(Login login) {
        return repositoryUser.login(login);
    }

    public String checkPasswordAndEmail(Login login) {
        List<User> user = repositoryUser.findByEmail(login.getEmail());
        if(user.isEmpty())  return  "FAIL";
        String pass = user.get(0).getPassword();
        if(!argon2.verify(pass , login.getPassword())) return "FAIL";

        return generateJWT(user.get(0));

    }

    public  String generateJWT(User user){
        return  jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
    }

}



