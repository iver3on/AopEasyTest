package com.zwb.myaop.myaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
        UserService userService = (UserService) ctx  
                .getBean("userservice");  
          
        System.out.println("拦截save方法，并获得输入参数(或错误信息)----------");  
        /**********拦截save方法，并获得输入参数(或错误信息)**********************/  
        userService.save("123");  
          
        System.out.println();  
          
        System.out.println("拦截getPersonName方法并获得返回参数");  
        /**********拦截getPersonName方法并获得返回参数**********************/  
        userService.getUserName(123);  


	}

}
