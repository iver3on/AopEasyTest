package com.zwb.myaop.myaop;

public class UserService {
	
	public String getUserName(int id){
		System.out.println("我是getUserName方法...");
		return "ok";
	}
	public void save(String name) {  
        //throw new RuntimeException("例外");  
        System.out.println("我是userService的save()方法");  
    }  
      
    public void update(String name,Integer id){  
        System.out.println("我是update()方法");  
    }  

}
