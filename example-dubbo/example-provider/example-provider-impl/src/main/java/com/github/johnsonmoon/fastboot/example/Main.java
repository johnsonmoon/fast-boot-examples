package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.server.impl.TomcatServerStartup;

/**
 * Created by johnsonmoon at 2018/5/16 17:48.
 */
public class Main {
    public static void main(String... args) {
        ApplicationStartup.startup(
                ApplicationConfiguration.create()
                        .springConfigLocation("classpath*:app-context.xml")
                        .host("127.0.0.1")
                        .port("9005")
                        .contextPath("/")
                        .serverStartup(new TomcatServerStartup())
        );
        ApplicationStartup.await();
    }
}
