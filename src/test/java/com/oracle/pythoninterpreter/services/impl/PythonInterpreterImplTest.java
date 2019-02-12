package com.oracle.pythoninterpreter.services.impl;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.services.CodeInterpreter;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/applicationContext.xml"})
public class PythonInterpreterImplTest {

	@Autowired
	@Qualifier(value = "pythonInterpreterImpl")
	public CodeInterpreter pythonInterpreterImpl;
	


	@Test
	public void shouldReturnHelloWorld() throws CodeFormatException {
		CodeToBeExecuted codeToBeExecuted = new CodeToBeExecuted();
		codeToBeExecuted.setCode("%python print('hello world')");
		Assertions.assertThat("hello world").isEqualToIgnoringCase(pythonInterpreterImpl.execute(codeToBeExecuted).getResult());
	}
	
	@Test
	public void shouldReturnEmpty() throws CodeFormatException {
		CodeToBeExecuted codeToBeExecuted = new CodeToBeExecuted();
		codeToBeExecuted.setCode("%python a=1");
		Assertions.assertThat("").isEqualToIgnoringCase(pythonInterpreterImpl.execute(codeToBeExecuted).getResult());
	}
	
	
	@Test
	public void shouldRememberVariables() throws CodeFormatException {
		CodeToBeExecuted codeToBeExecuted = new CodeToBeExecuted();
		codeToBeExecuted.setCode("%python a=1");
		Assertions.assertThat("").isEqualToIgnoringCase(pythonInterpreterImpl.execute(codeToBeExecuted).getResult());
		
		CodeToBeExecuted codeToBeExecutedAgain = new CodeToBeExecuted();
		codeToBeExecuted.setCode("%python print a+1");
		Assertions.assertThat("2").isEqualToIgnoringCase(pythonInterpreterImpl.execute(codeToBeExecuted).getResult());
	}
}