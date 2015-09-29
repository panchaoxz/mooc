package com.mooc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {

	public static  Logger LOGGER = LogManager.getLogger();
	
	@RequestMapping(method=GET)
	public String home(){
		LOGGER.info("executing home method");
		
		return "spittr";
	}
}
