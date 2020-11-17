package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.entity.ServletConfiguration;
import com.github.johnsonmoon.fastboot.core.server.impl.JettyServerStartup;
import com.github.johnsonmoon.fastboot.example.servlet.Servlet2;
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

        ServletConfiguration servlet2 = new ServletConfiguration();
        servlet2.setName("servlet2");
        servlet2.setPath("/api/v1/*");
        servlet2.setClass(Servlet2.class);

        ApplicationStartup.startup(
                ApplicationConfiguration.create()
                        .host("10.1.251.186")
                        .port("9002")
                        .contextPath("/")
                        .dispatcherDisable(true)//disable dispatcher required when default dispatcher servlet does not needed.
                        .servlet(servlet)
                        .servlet(servlet2)
                        .serverStartup(new JettyServerStartup())
                , Main.class
        );

        ApplicationStartup.await();
    }
}
