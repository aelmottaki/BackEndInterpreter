package com.oracle.pythoninterpreter.services;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;

public interface CodeInterpreter {
	 ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
}
