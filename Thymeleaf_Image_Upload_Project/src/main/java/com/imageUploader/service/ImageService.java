package com.imageUploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageUploader.dao.ImageDao;
import com.imageUploader.entity.ImageUpload;

@Service
public class ImageService 
{
	@Autowired
	private ImageDao dao;
	
	public ImageUpload saveImage(ImageUpload image)
	{
		ImageUpload saveimage = dao.save(image);
		return saveimage;
	}
}
