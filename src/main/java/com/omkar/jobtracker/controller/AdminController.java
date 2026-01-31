package com.omkar.jobtracker.controller;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	@GetMapping("/dashboard")
	public String adminDashboard() {
	    log.info("Admin dashboard accessed");
	    return "Welcome Admin 🔥";
	}

}
