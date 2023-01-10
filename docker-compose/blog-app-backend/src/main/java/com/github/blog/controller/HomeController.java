package com.github.blog.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/host")
	public String getHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		return "IP Address: " + addr.getHostAddress() + ", Computer Name: " + addr.getHostName();
	}

}
