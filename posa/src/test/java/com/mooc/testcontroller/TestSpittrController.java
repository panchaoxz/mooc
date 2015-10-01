package com.mooc.testcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.mooc.controller.SpittleController;
import com.mooc.dao.SpittleRepository;
import com.mooc.model.Spittle;

@RunWith(MockitoJUnitRunner.class)
public class TestSpittrController {

	public static Logger LOGGER = LogManager.getLogger();
	//private static SpittleRepository mockRepo;
	
	@Mock
	SpittleRepository mockRepo;
	
	@Test
	public void shouldShowrecentSpittles() throws Exception {

		List<Spittle> expectedSpittles = createSpittleList(100);
	
		when(mockRepo.findSpittles(Long.MAX_VALUE,100)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepo);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/JSPages/spittles.jsp"))
				.build();
		mockMvc.perform(get("/spittles?max=23890&count=50"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"));
		 
		for(Spittle spittle : expectedSpittles){
			LOGGER.info("SPITTLES -- "+spittle.getMessage());
		}
		 LOGGER.info("SPITTLES:-- done with spittles controller test");

	}

	
	private List<Spittle> createSpittleList(int arg) {
		List<Spittle> Spittles = new ArrayList<Spittle>();
		for (int ii = 0; ii < arg; ii++) {
			Spittles.add(new Spittle("Spittle " + ii, new Date()));
		}
		return Spittles;
	}
	
}
