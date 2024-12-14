package com.spring_ioc_applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test 
{
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring_ioc_applicationcontext/config.xml");

		Employee emp = context.getBean("employee",Employee.class);
		
		System.out.println(emp);
		
		System.out.println(emp.getEname());
	}
}
