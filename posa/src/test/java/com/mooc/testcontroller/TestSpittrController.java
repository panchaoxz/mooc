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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.mooc.controller.SpittleController;
import com.mooc.dao.SpittleRepository;
import com.mooc.model.Spittle;

import sun.security.provider.ConfigFile.Spi;

@RunWith(MockitoJUnitRunner.class)
public class TestSpittrController {

	public static Logger LOGGER = LogManager.getLogger();
	private long SpittleId = 45;
	// private static SpittleRepository mockRepo;

	@Mock
	SpittleRepository mockRepo;

	private List<Spittle> expectedSpittles;
	private Spittle spittle;

	@Before
	public void setUp() {
		expectedSpittles = createSpittleList(100);
		spittle = getOneSpittle(SpittleId);
	}

	@Test
	public void shouldShowrecentSpittles() throws Exception {

		when(mockRepo.findSpittles(Long.MAX_VALUE, 100))
		        .thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(mockRepo);

		MockMvc mockMvc = standaloneSetup(controller).setSingleView(
		        new InternalResourceView("/WEB-INF/JSPages/spittles.jsp"))
		        .build();

		mockMvc.perform(get("/spittles?max=23890&count=50"))
		        .andExpect(view().name("spittles"));

		for (Spittle spittle : expectedSpittles) {
			LOGGER.info("Spittle Id: " + spittle.getId() + "Message:"
			        + spittle.getMessage());
		}

		LOGGER.info("SPITTLES:-- done with spittles controller test");

	}

	@Test
	public void ShouldShowSingleSpittle() throws Exception {

		when(mockRepo.findOne(Long.MAX_VALUE, SpittleId)).thenReturn(spittle);
		SpittleController controller = new SpittleController(mockRepo);

		MockMvc mockMvc = standaloneSetup(controller).setSingleView(
		        new InternalResourceView("/WEB-INF/JSPages/spittle.jsp"))
		        .build();

		mockMvc.perform(get("/spittles/45")).andExpect(view().name("spittle"))
		        .andExpect(model().attributeExists("spittle"));

		LOGGER.info("SPITTLE:-- done with single spittle test");

	}

	private List<Spittle> createSpittleList(int arg) {
		List<Spittle> Spittles = new ArrayList<Spittle>();
		for (int ii = 0; ii < arg; ii++) {
			Spittles.add(new Spittle(ii, "Spittle " + ii, new Date()));
		}
		return Spittles;
	}

	private Spittle getOneSpittle(long id) {

		for (Spittle spittle : expectedSpittles) {

			if (id == spittle.getId())
				return spittle;
		}
		return null;
	}
}
