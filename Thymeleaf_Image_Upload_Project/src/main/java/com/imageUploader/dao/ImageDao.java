package com.imageUploader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imageUploader.entity.ImageUpload;

@Repository
public interface ImageDao extends JpaRepository<ImageUpload, Integer>
{
	
}
