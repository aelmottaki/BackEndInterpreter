package com.oracle.pythoninterpreter.parsers;

import com.oracle.pythoninterpreter.pojos.Code;

public interface CodeExtractor {
	String getExtractedCode(Code code);
}
