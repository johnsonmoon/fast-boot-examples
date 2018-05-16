package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.entity.ServletConfiguration;
import com.github.johnsonmoon.fastboot.example.servlet.TestServlet;

/**
 * Created by johnsonmoon at 2018/5/16 15:23.
 */
public class Main {
    public static void main(String... args) {
        ApplicationConfiguration configuration = new ApplicationConfiguration();
        configuration.setSpringConfigLocation("classpath*:app-context*.xml");
        configuration.setHost("127.0.0.1");
        configuration.setPort("9002");
        configuration.setContextPath("/");
        //-- servlet
        ServletConfiguration servlet = new ServletConfiguration();
        servlet.setName("testServlet");
        servlet.setPath("/service/*");
        servlet.setClass(TestServlet.class);
        //--
        configuration.setDispatcherDisable(true);//disable dispatcher required when default dispatcher servlet does not needed.
        configuration.addServlet(servlet);
        ApplicationStartup.startup(configuration);
    }
}
