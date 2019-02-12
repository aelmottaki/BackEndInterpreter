package com.oracle.pythoninterpreter.services.impl;


import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.services.CodeFormatter;
import com.oracle.pythoninterpreter.services.CodeInterpreter;

import java.util.Map;

public class InterpreterFactory {
	private Map<String, CodeInterpreter> interpreters;
	private CodeInterpreter defaultInterpreter;
	private CodeFormatter codeFormatter;
	
	public CodeInterpreter getInterpreter(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException {
		String languagePrefix = codeFormatter.getPrefix(codeToBeExecuted);
		if(interpreters.containsKey(languagePrefix)){
			return interpreters.get(languagePrefix);
		}
		return  defaultInterpreter;
	}
	
	
	public void setCodeFormatter(CodeFormatter codeFormatter) {
		this.codeFormatter = codeFormatter;
	}
	
	public void setInterpreters(Map<String, CodeInterpreter> interpreters) {
		this.interpreters = interpreters;
	}
	
	public void setDefaultInterpreter(CodeInterpreter defaultInterpreter) {
		this.defaultInterpreter = defaultInterpreter;
	}
}
