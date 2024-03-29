package com.hcl.mortgage.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.mortgage.service.AccountSummaryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AccountSummaryControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(AccountSummaryControllerTest.class);

	@InjectMocks
	AccountSummaryController accountSummaryController;

	@Mock
	AccountSummaryServiceImpl accountSummaryServiceImpl;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(accountSummaryController).build();
	}

	@Test
	public void testGetAccountSummary() throws Exception {
		logger.info("in getAccountSummary() ");
		mockMvc.perform(MockMvcRequestBuilders.get("/api/summary/{cutomerId}", 1)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
