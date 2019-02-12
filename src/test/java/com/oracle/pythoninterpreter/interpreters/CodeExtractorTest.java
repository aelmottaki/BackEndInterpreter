package com.oracle.pythoninterpreter.interpreters;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.parsers.impl.CodeExtractorImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CodeExtractorTest {
	@Test
	public void shouldReturnNoLanguagePrefix() throws CodeFormatException {
		CodeExtractorImpl codeFormatter = new CodeExtractorImpl();
		Code code = new Code();
		code.setCode("%python print(test) ");
		Assertions.assertThat("print(test)").isEqualToIgnoringCase(codeFormatter.getExtractedCode(code));
	}
	
	@Test(expected = CodeFormatException.class)
	public void shouldThrowException() throws CodeFormatException {
		CodeExtractorImpl codeFormatter = new CodeExtractorImpl();
		Code code = new Code();
		code.setCode("python print(test) ");
		Assertions.assertThat("print(test)").isEqualToIgnoringCase(codeFormatter.getExtractedCode(code));
	}
	
}