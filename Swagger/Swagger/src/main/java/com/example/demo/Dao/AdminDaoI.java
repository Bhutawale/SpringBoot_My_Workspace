package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Admin;

@Repository
public interface AdminDaoI extends JpaRepository<Admin,Integer>
{

}
