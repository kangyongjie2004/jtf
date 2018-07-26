//package com.jd.jtf.demo.plugin.test;
//
//import com.jd.jtf.demo.plugin.PrintService;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringDiTest {
//
//	ApplicationContext testContext = new ClassPathXmlApplicationContext("spring-config.xml");
//	PrintService cateService = (PrintService) testContext.getBean(PrintService.class);
//
//
//	@Test
//	public void springDItest() {
//		cateService.print();
//	}
//
//}