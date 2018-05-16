package com.github.johnsonmoon.fastboot.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by johnsonmoon at 2018/5/16 16:06.
 */
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------\n\n");
        stringBuilder.append("Hello! Johnson!");
        stringBuilder.append("\n\n------------------------------------");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------\n\n");
        stringBuilder.append("Goodbye! Johnson!");
        stringBuilder.append("\n\n------------------------------------");
        System.out.println(stringBuilder.toString());
    }
}
