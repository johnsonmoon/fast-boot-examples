package com.github.johnsonmoon.fastboot.example.restservice;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.server.impl.TomcatServerStartup;
import com.github.johnsonmoon.fastboot.example.restservice.provider.GlobalExceptionHandler;
import com.github.johnsonmoon.fastboot.example.restservice.provider.GlobalFilter;

/**
 * Created by johnsonmoon at 2018/5/16 13:55.
 */
public class Main {
    public static void main(String... args) {
        ApplicationStartup.startup(
                ApplicationConfiguration.create()
                        .host("127.0.0.1")
                        .port("9001")
                        .contextPath("/")
                        .provider(GlobalExceptionHandler.class)
                        .provider(GlobalFilter.class)
                        .serverStartup(new TomcatServerStartup()),
                Main.class
        );
        ApplicationStartup.await();
    }
}
