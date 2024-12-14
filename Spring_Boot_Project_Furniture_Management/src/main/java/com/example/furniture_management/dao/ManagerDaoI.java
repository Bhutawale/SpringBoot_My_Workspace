package com.example.furniture_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.furniture_management.model.Manager;

@Repository
public interface ManagerDaoI extends JpaRepository<Manager, Integer>
{

}
