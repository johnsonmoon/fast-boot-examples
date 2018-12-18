package com.github.johnsonmoon.fastboot.example.restservice.sevice.impl;

import com.github.johnsonmoon.fastboot.core.annotation.RestService;
import com.github.johnsonmoon.fastboot.example.restservice.sevice.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 * Created by johnsonmoon at 2018/5/16 13:57.
 */
@RestService
@Path("/service")
public class TestServiceImpl implements TestService {
	@GET
	@Path("/test")
	public String test(@HeaderParam("test_message") String test_message) {
		return "Filtering message: " + test_message;
	}

	@GET
	@Path("/exception")
	public String testException() {
		throw new RuntimeException("Yes");
	}
}
