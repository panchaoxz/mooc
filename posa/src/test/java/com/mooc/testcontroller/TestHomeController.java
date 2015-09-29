package com.mooc.testcontroller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.mooc.controller.HomeController;
import com.mooc.controller.SpittleController;
import com.mooc.dao.SpittleRepository;
import com.mooc.model.Spittle;

@RunWith(MockitoJUnitRunner.class)
public class TestHomeController {

	public static Logger LOGGER = LogManager.getLogger();
	//private static SpittleRepository mockRepo;
	
	@Mock
	SpittleRepository mockRepo;
	
	@Test
	public void shouldShowrecentSpittles() throws Exception {

		List<Spittle> expectedSpittles = createSpittleList(20);

		when(mockRepo.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepo);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/JSPages/spittles.jsp"))
				.build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList",equalTo(expectedSpittles)));
		 
		for(Spittle spittle : expectedSpittles){
			LOGGER.info("SPITTLES -- "+spittle.getMessage());
		}
		 LOGGER.info("SPITTLES:-- done with spittles controller test");

	}

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockController = standaloneSetup(controller).build();

		mockController.perform(get("/")).andExpect(view().name("spittr"));
		LOGGER.info("HOME :--- done with home controller test");
	}

	private List<Spittle> createSpittleList(int arg) {
		List<Spittle> Spittles = new ArrayList<Spittle>();
		for (int ii = 0; ii < arg; ii++) {
			Spittles.add(new Spittle("Spittle " + ii, new Date()));
		}
		return Spittles;
	}

}
