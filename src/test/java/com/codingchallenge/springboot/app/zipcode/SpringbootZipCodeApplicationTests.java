package com.codingchallenge.springboot.app.zipcode;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Assert;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

//import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;
//import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class SpringbootZipCodeApplicationTests {

	/*private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();*/
	
	@Test
	void contextLoads() {
	}
	
	/*@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}
	
	@Test
	public void getAllZipCodes() throws Exception {
		MvcResult result = mockMvc.perform(get("/listAll").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		ZipCodes response = om.readValue(resultContent, ZipCodes.class);
		Assert.assertTrue(response.getD_codigo() != 0);
	}*/
	
}
