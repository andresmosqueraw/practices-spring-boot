package com.example.practice7persistencia.dao;

import com.example.practice7persistencia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findByDocument(String document);
    User findByDocumentAndPassword(String document, String password);
    User findByEmailAndDocument(String email, String document);
}

