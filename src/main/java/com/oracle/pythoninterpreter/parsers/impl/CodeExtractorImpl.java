package com.oracle.pythoninterpreter.parsers.impl;

import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;



public class CodeExtractorImpl implements CodeExtractor {
	
	private static final String SEPARATOR = " ";
	private static final String EMPTY = "";

	@Override
	public String getExtractedCode(Code code) {
		String languagePrefix = code.getCode().split(SEPARATOR)[0];
		return code.getCode().replace(languagePrefix, EMPTY).trim();
	}
}
