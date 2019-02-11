package com.pythoninterpreter.pythoninterpreter.services;

import com.pythoninterpreter.pythoninterpreter.exceptions.CodeFormatException;
import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;

public interface CodeFormatter {
	String format(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
	String getPrefix(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
}
