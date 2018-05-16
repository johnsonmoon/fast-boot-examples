package com.github.johnsonmoon.fastboot.example.provider;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by johnsonmoon at 2018/5/16 14:00.
 */
public class GlobalFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("test_message", "Hello! Johnson!");
    }
}
