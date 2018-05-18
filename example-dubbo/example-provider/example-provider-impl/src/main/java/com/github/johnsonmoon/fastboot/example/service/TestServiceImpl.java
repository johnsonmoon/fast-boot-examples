package com.github.johnsonmoon.fastboot.example.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by johnsonmoon at 2018/5/16 17:49.
 */
@Service
@Path("/service")
public class TestServiceImpl implements TestService {
	@GET
	@Path("/test")
	@Override
	public String test(@QueryParam("name") String name) {
		return "Hello! " + name;
	}
}
