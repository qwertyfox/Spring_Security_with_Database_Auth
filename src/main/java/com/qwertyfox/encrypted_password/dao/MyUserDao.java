package com.qwertyfox.encrypted_password.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserDao extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);

}
