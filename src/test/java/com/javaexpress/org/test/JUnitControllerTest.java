package com.javaexpress.org.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexpress.org.Response;
import com.javaexpress.org.model.User;





@RunWith(SpringRunner.class)
@SpringBootTest
public class JUnitControllerTest{
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void saveUserTest()throws Exception {
		User user=new User();
		user.setId(1l);
		user.setFirstName("Massoud");
		user.setAge(23);
		user.setEmail("example@yahoo.com");
		String jsonRequest = om.writeValueAsString(user);
		MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		//Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}
}
