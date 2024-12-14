package com.imageUploader.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imageUploader.entity.ImageUpload;
import com.imageUploader.service.ImageService;

@Controller
@RequestMapping("/image")
public class ImageController 
{
	@Autowired
	private ImageService service;
	
	@GetMapping("/uploadImageForm")
	public String imageform(Model model)
	{
		model.addAttribute("ImageIpload", new ImageUpload());
		return "imageForm";
	}
	
	@PostMapping("/processform")
	public String processform(@ModelAttribute ImageUpload image,
			@RequestParam("image") MultipartFile file,
			Model model)
	{
		String filename = file.getOriginalFilename();
		
		System.out.println(filename);
		
		if(filename!=null && !filename.isEmpty())
		{
			try
			{
				image.setImagename(filename);
				
				File imageFile = new ClassPathResource("static/uploads").getFile();
				
				Path path = Paths.get(imageFile.getAbsolutePath()+File.separator+filename);
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			service.saveImage(image);
			model.addAttribute("ImageUpload", image);
			return "success";
		}
		
		else
		{
			return "imageForm";
		}
	}
}
