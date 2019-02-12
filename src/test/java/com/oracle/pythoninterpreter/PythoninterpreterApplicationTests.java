package com.oracle.pythoninterpreter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.pythoninterpreter.controllers.ErrorController;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.controllers.ExecutionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExecutionController.class)
@ComponentScan(basePackages = "com.oracle.pythoninterpreter")
public class PythoninterpreterApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	
	
	@Test
	public void shouldReturnHelloWorld() throws Exception {
		Code code = new Code();
		code.setCode("%python print('hello world')");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
				mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").value("hello world"));
	}
	
	@Test
	public void shouldReturnEmpty() throws Exception {
		Code code = new Code();
		code.setCode("%python a=10");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").isEmpty());
	}
	
	@Test()
	public void shouldStatusBe400IfSyntaxCodeError() throws Exception {
		Code code = new Code();
		code.setCode("%python print a");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value((ErrorController.CODE_SYNTAX_ERROR_CHECK_YOUR_CODE_PLEASE)));
	}

	@Test()
	public void shouldReturnBadRequestIfNoInterpreterFound() throws Exception {
		Code code = new Code();
		code.setCode("%dotenet print a");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();

		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value((ErrorController.NO_INTERPRETER_FOUND_EXCEPTION)));
	}

	@Test()
	public void shouldStatusBe400IfInterpreterNotFound() throws Exception {
		Code code = new Code();
		code.setCode("print a");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value((ErrorController.NO_INTERPRETER_FOUND_EXCEPTION)));
	}
	
	@Test
	public void shouldRememberVariableIfSameSession() throws Exception {
		MockHttpSession httpSession = new MockHttpSession();
		Code code = new Code();
		code.setCode("%python a=10");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.session(httpSession)
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(""));
		
		code.setCode("%python print a+10");
		MvcResult mvcResult1 =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.session(httpSession)
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").value("20"));
	}
	
	@Test
	public void shouldNotRememberVariableIfNotSameSession() throws Exception {
		MockHttpSession httpSession = new MockHttpSession();
		Code code = new Code();
		code.setCode("%python a=10");
		MvcResult mvcResult =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.session(httpSession)
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(""));
		
		// new Session
		code.setCode("%python print a+10");
		httpSession = new MockHttpSession();
		MvcResult mvcResult1 =mockMvc.perform( MockMvcRequestBuilders
				.post("/execute")
				.session(httpSession)
				.content(asJsonString(code))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(request().asyncStarted()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult1)).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.jsonPath("$.message").value((ErrorController.CODE_SYNTAX_ERROR_CHECK_YOUR_CODE_PLEASE)));
	}
	
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

