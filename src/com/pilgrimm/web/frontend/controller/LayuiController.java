package com.pilgrimm.web.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/layui")
public class LayuiController {
	
	@RequestMapping("/index")
	public String index() {
		return "/frontend/layui/index";
	}
	
}
