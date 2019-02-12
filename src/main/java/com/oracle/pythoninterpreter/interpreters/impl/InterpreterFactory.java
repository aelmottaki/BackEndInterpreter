package com.oracle.pythoninterpreter.interpreters.impl;


import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.exceptions.NoInterpreterFoundException;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.interpreters.CodeInterpreter;

import java.util.Map;

public class InterpreterFactory {
	private Map<String, CodeInterpreter> interpreters;
	private CodeExtractor codeExtractor;
	
	public CodeInterpreter getInterpreter(Code code) throws CodeFormatException, NoInterpreterFoundException {
		String languagePrefix = codeExtractor.getPrefix(code);
		if(interpreters.containsKey(languagePrefix)){
			return interpreters.get(languagePrefix);
		}
		throw new NoInterpreterFoundException();
	}
	
	
	public void setCodeExtractor(CodeExtractor codeExtractor) {
		this.codeExtractor = codeExtractor;
	}
	
	public void setInterpreters(Map<String, CodeInterpreter> interpreters) {
		this.interpreters = interpreters;
	}
	
}
