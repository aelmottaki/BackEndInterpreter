package com.oracle.pythoninterpreter.services;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.services.impl.CodeFormatterImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CodeFormatterTest {
	@Test
	public void shouldReturnNoLanguagePrefix() throws CodeFormatException {
		CodeFormatterImpl codeFormatter = new CodeFormatterImpl();
		CodeToBeExecuted codeToBeExecuted = new CodeToBeExecuted();
		codeToBeExecuted.setCode("%python print(test) ");
		Assertions.assertThat("print(test)").isEqualToIgnoringCase(codeFormatter.format(codeToBeExecuted));
	}
	
	@Test(expected = CodeFormatException.class)
	public void shouldThrowException() throws CodeFormatException {
		CodeFormatterImpl codeFormatter = new CodeFormatterImpl();
		CodeToBeExecuted codeToBeExecuted = new CodeToBeExecuted();
		codeToBeExecuted.setCode("python print(test) ");
		Assertions.assertThat("print(test)").isEqualToIgnoringCase(codeFormatter.format(codeToBeExecuted));
	}
	
}