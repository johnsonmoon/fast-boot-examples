package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.entity.FilterConfiguration;
import com.github.johnsonmoon.fastboot.core.server.impl.TomcatServerStartup;
import com.github.johnsonmoon.fastboot.example.filter.TestFilter;

/**
 * Created by johnsonmoon at 2018/5/16 16:14.
 */
public class Main {
    public static void main(String... args) {
        FilterConfiguration filter = new FilterConfiguration();
        filter.setName("testFilter");
        filter.setClass(TestFilter.class);
        filter.setPath("/service/*");

        ApplicationStartup.startup(
                ApplicationConfiguration.create()
                        .host("127.0.0.1")
                        .port("9004")
                        .contextPath("/")
                        .serverStartup(new TomcatServerStartup())
                        .filter(filter),
                Main.class
        );
        ApplicationStartup.await();
    }
}
