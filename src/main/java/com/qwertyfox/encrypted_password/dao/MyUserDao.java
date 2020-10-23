package com.qwertyfox.encrypted_password.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserDao extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findByUsername(String username);

}
