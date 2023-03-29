package com.apirest.apirest.repositories;
import java.util.List;

import com.apirest.apirest.models.Login;
import com.apirest.apirest.models.User;

public interface RepositoryUser {
    User getUserById(String id);
    List<User> allUser();
    User updateUser(User user);
    void deleteUser(Long id);
    void registerUser(User user);

    User login(Login login);

    List<User> findByEmail(String email);
}
