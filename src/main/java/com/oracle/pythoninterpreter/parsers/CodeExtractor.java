package com.oracle.pythoninterpreter.parsers;

import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;

public interface CodeExtractor {
	String getExtractedCode(Code code);
}
