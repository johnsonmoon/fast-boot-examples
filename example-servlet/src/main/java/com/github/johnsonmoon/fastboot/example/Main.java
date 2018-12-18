package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.entity.ServletConfiguration;
import com.github.johnsonmoon.fastboot.core.server.impl.TomcatServerStartup;
import com.github.johnsonmoon.fastboot.example.servlet.TestServlet;

/**
 * Created by johnsonmoon at 2018/5/16 15:23.
 */
public class Main {
	public static void main(String... args) {
		ServletConfiguration servlet = new ServletConfiguration();
		servlet.setName("testServlet");
		servlet.setPath("/service/*");
		servlet.setClass(TestServlet.class);

		ApplicationStartup.startup(
				ApplicationConfiguration.create()
				.host("127.0.0.1")
				.port("9002")
				.contextPath("/")
				.dispatcherDisable(true)//disable dispatcher required when default dispatcher servlet does not needed.
				.servlet(servlet)
				.serverStartup(new TomcatServerStartup())
				, Main.class
		);

		ApplicationStartup.await();
	}
}
