package com.example.practice7persistencia.service;

import com.example.practice7persistencia.dao.IUserDAO;
import com.example.practice7persistencia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserDAO userDAO;

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userDAO.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userDAO.findByEmail(email));
    }

    public User createUser(User user) {
        return userDAO.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setNames(userDetails.getNames());
        user.setLastNames(userDetails.getLastNames());
        user.setDocument(userDetails.getDocument());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userDAO.save(user);
    }

    public void deleteUser(Long id) {
        User user = userDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userDAO.delete(user);
    }
}

