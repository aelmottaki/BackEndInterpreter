package com.oracle.pythoninterpreter.services.impl;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.services.CodeFormatter;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import org.apache.commons.lang.StringUtils;



public class CodeFormatterImpl implements CodeFormatter {
	
	private static final String SEPARATOR = " ";
	private static final String EMPTY = "";
	private String regexFormat = "%[a-zA-Z]{3,10}\\s.*"; // default value to change it in config spring
	
	@Override
	public String format(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException {
		if(StringUtils.isEmpty(codeToBeExecuted.getCode()) || codeHasBadFormat(codeToBeExecuted.getCode())){
			throw new CodeFormatException("code format error !");
		}
		String languagePrefix = codeToBeExecuted.getCode().split(SEPARATOR)[0];
		return codeToBeExecuted.getCode().replace(languagePrefix, EMPTY).trim();
	}
	
	@Override
	public String getPrefix(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException {
		if(StringUtils.isEmpty(codeToBeExecuted.getCode()) || codeHasBadFormat(codeToBeExecuted.getCode())){
			throw new CodeFormatException("code format error !");
		}
		return codeToBeExecuted.getCode().split(SEPARATOR)[0];
	}
	
	private boolean codeHasBadFormat(String code) {
		return !code.matches(regexFormat);
	}
	// to be used by spring 
	public void setRegexFormat(String regexFormat) {
		regexFormat = regexFormat;
	}
}
