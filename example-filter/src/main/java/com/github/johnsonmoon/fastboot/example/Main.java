package com.github.johnsonmoon.fastboot.example;

import com.github.johnsonmoon.fastboot.core.ApplicationStartup;
import com.github.johnsonmoon.fastboot.core.entity.ApplicationConfiguration;
import com.github.johnsonmoon.fastboot.core.entity.FilterConfiguration;
import com.github.johnsonmoon.fastboot.example.filter.TestFilter;

/**
 * Created by johnsonmoon at 2018/5/16 16:14.
 */
public class Main {
    public static void main(String... args) {
        ApplicationConfiguration configuration = new ApplicationConfiguration();
        configuration.setSpringConfigLocation("classpath*:app-context*.xml");
        configuration.setHost("127.0.0.1");
        configuration.setPort("9004");
        configuration.setContextPath("/");
        //-- filter
        FilterConfiguration filter = new FilterConfiguration();
        filter.setName("testFilter");
        filter.setClass(TestFilter.class);
        filter.setPath("/service/*");
        configuration.addFilter(filter);
        // --
        ApplicationStartup.startup(configuration);
    }
}
