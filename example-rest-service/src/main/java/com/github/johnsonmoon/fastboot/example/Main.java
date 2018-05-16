package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.example.provider.GlobalExceptionHandler;
import com.github.johnsonmoon.fastboot.example.provider.GlobalFilter;

/**
 * Created by johnsonmoon at 2018/5/16 13:55.
 */
public class Main {
    public static void main(String... args) {
        ApplicationConfiguration configuration = new ApplicationConfiguration();
        configuration.setSpringConfigLocation("classpath*:app-context*.xml");
        configuration.setHost("127.0.0.1");
        configuration.setPort("9001");
        configuration.setContextPath("/");
        configuration.addProvider(GlobalExceptionHandler.class);
        configuration.addProvider(GlobalFilter.class);
        ApplicationStartup.startup(configuration);
    }
}
