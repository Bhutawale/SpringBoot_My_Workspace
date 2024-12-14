package com.imageUploader.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageUpload 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imageid;
	private String imagename;
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	@Override
	public String toString() {
		return "ImageUpload [imageid=" + imageid + ", imagename=" + imagename + "]";
	}
	
	
}
