package com.example.practice7persistencia.dao;


import com.example.practice7persistencia.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    public User deleteUser(User user) {
        entityManager.remove(user);
        return user;
    }
}
