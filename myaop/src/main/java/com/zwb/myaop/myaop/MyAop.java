package com.zwb.myaop.myaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAop {
	@Pointcut("execution (* com.zwb.myaop.myaop.UserService.*(..))")  
    private void anyMethod(){};//声明一个切入点  
      
      
    /***********获得参数值(此时拦截方法，只针对有String name参数的方法)****************/  
    @Before("anyMethod() && args(name)")//  
    public void doAccessCheck(String name){  
        System.out.println("前置通知:"+name);  
    }  
      
    /***********获得返回值****************/  
    @AfterReturning(pointcut="anyMethod()",returning="result")//获得返回值  
    public void doAfterReturning(String result){  
        System.out.println("后置通知:"+result);  
    }  
      
    @After("anyMethod()")  
    public void doAfter(){  
        System.out.println("最终通知");  
    }  
  
    /***********获得错误****************/  
    @AfterThrowing(pointcut="anyMethod()",throwing="ex")//获得错误  
    public void doAfterThrowing(Exception ex){  
        System.out.println("例外通知:"+ex);  
    }  
  
    /*************环绕通知  返回值 和  参数类型  不可变******************************/  
    @Around("anyMethod()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {  
        //if(){//判断用户是否有权限  
        System.out.println("进入方法");  
        Object result=pjp.proceed();  
        System.out.println("退出方法");  
        //}  
        return result;  
    }  
  

}
