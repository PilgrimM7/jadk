package com.pilgrimm.web.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/bootstrap")
public class BootstrapController {
	
	@RequestMapping("/index")
	public String abc() {
		return "/frontend/bootstrap/index";
	}
	
}
