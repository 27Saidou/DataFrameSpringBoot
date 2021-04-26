package com.javaexpress.org.test;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.javaexpress.org.controller.UserController;
import com.javaexpress.org.service.UserService;





@WebMvcTest(controllers = UserController.class)
public class JUnitControllerTest{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;

	
	 @Test
	    public void testGetEmployees() throws Exception {
	        mockMvc.perform(get("/api/v1/"))
	            .andExpect(status().isOk());
	    }
}
