package com.apirest.apirest.repositories;

import com.apirest.apirest.models.Login;
import com.apirest.apirest.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;

@Repository
public class RepositoryUserImp implements RepositoryUser {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User getUserById(String id) {
       String query = "FROM User WHERE id = :id";
        return null;
    }

    public List<User> allUser() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional
    public User updateUser(User user) {
        return null;
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Transactional
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User login(Login login) {
        return null;
    }

    @Override
    @Transactional
    public List<User> findByEmail(String email) {
        String params = "FROM User WHERE email = :email";
        List<User> user = entityManager.createQuery(params)
                .setParameter("email", email)
                .getResultList();
        return user;

    }


}
