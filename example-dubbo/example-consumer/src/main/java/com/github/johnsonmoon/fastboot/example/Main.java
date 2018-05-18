package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.example.service.TestService;
import com.github.johnsonmoon.fastboot.example.util.HttpUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by johnsonmoon at 2018/5/18 15:19.
 */
public class Main {
	public static void main(String... args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:app-context.xml");
		context.registerShutdownHook();

		//-- invoke with dubbo protocol
		TestService testService = (TestService) context.getBean("testService");
		System.out.println(testService.test("Johnson"));

		//-- invoke with http protocol
		System.out.println(HttpUtils.get("http://127.0.0.1:9005/service/test?name=John"));
	}
}
