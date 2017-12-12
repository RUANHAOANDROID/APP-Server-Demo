package com.alarm.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class AppServer {
	@ResponseBody
	@GetMapping(path = "/")
	String index() {
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(AppServer.class, args);
	}
}
