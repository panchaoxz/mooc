package com.mooc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mooc.dao.SpittleRepository;
import com.mooc.model.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepo;
	
	public static Logger LOGGER = LogManager.getLogger();

	public SpittleController() {}
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepo){
		this.spittleRepo = spittleRepo;
	}
	@RequestMapping(method=GET)
	public List<Spittle> getSpittles(@RequestParam("max")long max,
			@RequestParam("count")int count){
		LOGGER.info("Go!! get spittle request for count"+count);
		List<Spittle> spittleList = spittleRepo.findSpittles(max,count);
		
		return spittleList;		
	}
}
