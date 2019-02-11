package com.pythoninterpreter.pythoninterpreter.services;

import com.pythoninterpreter.pythoninterpreter.exceptions.CodeFormatException;
import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;
import com.pythoninterpreter.pythoninterpreter.pojos.ExecutionResult;

public interface CodeInterpreter {
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException;
}
