package com.pilgrimm.web.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pilgrimm.core.common.AbstractController;

@Controller
@RequestMapping("/home")
public class HomeController extends AbstractController {

	/**
	 * 列表页 
	 */
	@RequestMapping("/workplate")
	public String workplate() {
		return "/home/workplate";
	}
	
	/**
	 * 列表页 
	 */
	@RequestMapping("/metronic/index")
	public String index2() {
		return "/home/metronic/index";
	}
	
	/**
	 * 列表页 
	 */
	@RequestMapping("/hplus/index")
	public String index() {
		return "/home/hplus/index";
	}

}
