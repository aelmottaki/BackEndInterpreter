package com.oracle.pythoninterpreter.interpreters.impl;


import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.exceptions.NoInterpreterFoundException;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;
import com.oracle.pythoninterpreter.parsers.LangPrefixPicker;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.interpreters.CodeInterpreter;

import java.util.Map;

public class InterpreterFactory {
	private Map<String, CodeInterpreter> interpreters;
	private LangPrefixPicker langPrefixPicker;
	
	public CodeInterpreter getInterpreter(Code code) throws CodeFormatException, NoInterpreterFoundException {
		String languagePrefix = langPrefixPicker.getPrefix(code);
		if(interpreters.containsKey(languagePrefix)){
			return interpreters.get(languagePrefix);
		}
		throw new NoInterpreterFoundException();
	}
	
	

	public void setLangPrefixPicker(LangPrefixPicker langPrefixPicker) {
		this.langPrefixPicker = langPrefixPicker;
	}

	public void setInterpreters(Map<String, CodeInterpreter> interpreters) {
		this.interpreters = interpreters;
	}
	
}
