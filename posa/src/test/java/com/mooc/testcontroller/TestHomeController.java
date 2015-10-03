package com.mooc.testcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mooc.controller.HomeController;


@RunWith(MockitoJUnitRunner.class)
public class TestHomeController {
	
	public static Logger LOGGER = LogManager.getLogger();
	
	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockController = standaloneSetup(controller).build();

		mockController.perform(get("/")).andExpect(view().name("spittr"));
		LOGGER.info("HOME :--- done with home controller test");
	}

}
