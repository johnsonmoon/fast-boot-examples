package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.example.listener.TestListener;

/**
 * Created by johnsonmoon at 2018/5/16 16:05.
 */
public class Main {
	public static void main(String... args) {
		ApplicationConfiguration configuration = new ApplicationConfiguration();
		configuration.setSpringConfigLocation("classpath*:app-context*.xml");
		configuration.setHost("127.0.0.1");
		configuration.setPort("9003");
		configuration.setContextPath("/");
		//-- listener
		configuration.addListener(new TestListener());
		//--
		ApplicationStartup.startup(configuration);

		//--
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//--
		ApplicationStartup.getServerStartup().stopServer();
		System.exit(0);
	}
}
