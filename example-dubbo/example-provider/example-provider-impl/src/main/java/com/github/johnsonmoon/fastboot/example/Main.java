package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;

/**
 * Created by johnsonmoon at 2018/5/16 17:48.
 */
public class Main {
	public static void main(String... args) {
		ApplicationConfiguration configuration = new ApplicationConfiguration();
		configuration.setSpringConfigLocation("classpath*:app-context.xml");
		configuration.setContextPath("/");
		configuration.setHost("127.0.0.1");
		configuration.setPort("9005");
		//--
		ApplicationStartup.startup(configuration);
	}
}
