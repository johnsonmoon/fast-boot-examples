package com.github.johnsonmoon.fastboot.example.sevice.impl;

import com.github.johnsonmoon.fastboot.example.sevice.TestService;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 * Created by johnsonmoon at 2018/5/16 13:57.
 */
@Service
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
