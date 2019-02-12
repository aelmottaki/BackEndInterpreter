package com.oracle.pythoninterpreter.parsers;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;

public interface CodeExtractor {
	String format(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
	String getPrefix(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
}
