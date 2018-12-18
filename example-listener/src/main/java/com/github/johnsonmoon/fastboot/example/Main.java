package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.example.listener.TestListener;

/**
 * Created by johnsonmoon at 2018/5/16 16:05.
 */
public class Main {
    public static void main(String... args) {
        ApplicationStartup.startup(
                ApplicationConfiguration.create()
                        .host("127.0.0.1")
                        .port("9003")
                        .contextPath("/")
                        .listener(new TestListener()),
                Main.class
        );
        ApplicationStartup.await();
    }
}
