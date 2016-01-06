package com.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App {
	
	public static void main(String[] args) {
		//bossGoSomewhere();
		smartBossGoSomewhere();
	}
	
/*	static void bossGoSomewhere() {
		Boss boss = new Boss();
		boss.goSomewhere();
	}*/
	
	static void smartBossGoSomewhere() {
	/*	AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				App.class);
		try {
			SmartBoss boss = context.getBean(SmartBoss.class);
			boss.goSomewhere();
		} finally {
			context.close();
		}*/
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
        CtripBookingService bookService = (CtripBookingService) ctx  
                .getBean("ctripservice");  
        bookService.bookFlight();
        QunarBookingService bookService1 = (QunarBookingService) ctx  
                .getBean("qunarservice");  
        bookService1.bookFlight();
        SmartBoss boss = (SmartBoss) ctx.getBean("smartboss");
        boss.goSomewhere();
	}
}