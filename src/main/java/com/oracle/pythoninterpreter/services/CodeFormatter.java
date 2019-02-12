package com.oracle.pythoninterpreter.services;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.exceptions.CodeFormatException;

public interface CodeFormatter {
	String format(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
	String getPrefix(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
}
