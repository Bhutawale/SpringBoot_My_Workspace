package com.microservice.userservice.UserService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.userservice.UserService.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
