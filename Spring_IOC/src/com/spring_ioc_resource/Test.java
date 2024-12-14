package com.spring_ioc_resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test
{
	public static void main(String[] args) 
	{
		Resource resource=new ClassPathResource("com/spring_ioc_resource/config.xml");
		
		BeanFactory factory=new XmlBeanFactory(resource);
		
		Student stu = factory.getBean("student",Student.class);
		
		System.out.println(stu);
		
		System.out.println(stu.getSname());
		
	}
}
