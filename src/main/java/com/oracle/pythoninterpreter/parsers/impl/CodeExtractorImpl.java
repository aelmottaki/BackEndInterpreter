package com.oracle.pythoninterpreter.parsers.impl;

import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import org.apache.commons.lang.StringUtils;



public class CodeExtractorImpl implements CodeExtractor {
	
	private static final String SEPARATOR = " ";
	private static final String EMPTY = "";

	@Override
	public String getExtractedCode(Code code) {
		String languagePrefix = code.getCode().split(SEPARATOR)[0];
		return code.getCode().replace(languagePrefix, EMPTY).trim();
	}
}
