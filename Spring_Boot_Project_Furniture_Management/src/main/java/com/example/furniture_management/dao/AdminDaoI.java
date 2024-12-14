package com.example.furniture_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.furniture_management.model.Admin;

@Repository
public interface AdminDaoI extends JpaRepository<Admin, Integer>
{

}
