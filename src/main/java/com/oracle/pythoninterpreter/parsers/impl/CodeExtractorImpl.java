package com.oracle.pythoninterpreter.parsers.impl;

import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import org.apache.commons.lang.StringUtils;



public class CodeExtractorImpl implements CodeExtractor {
	
	private static final String SEPARATOR = " ";
	private static final String EMPTY = "";
	private String regexFormat = "%[a-zA-Z]{3,10}\\s.*"; // default value to change it in config spring
	
	@Override
	public String format(Code code) throws CodeFormatException {
		if(StringUtils.isEmpty(code.getCode()) || codeHasBadFormat(code.getCode())){
			throw new CodeFormatException("code format error !");
		}
		String languagePrefix = code.getCode().split(SEPARATOR)[0];
		return code.getCode().replace(languagePrefix, EMPTY).trim();
	}
	
	@Override
	public String getPrefix(Code code) throws CodeFormatException {
		if(StringUtils.isEmpty(code.getCode()) || codeHasBadFormat(code.getCode())){
			throw new CodeFormatException("code format error !");
		}
		return code.getCode().split(SEPARATOR)[0];
	}
	
	private boolean codeHasBadFormat(String code) {
		return !code.matches(regexFormat);
	}
	// to be used by spring 
	public void setRegexFormat(String regexFormat) {
		regexFormat = regexFormat;
	}
}
