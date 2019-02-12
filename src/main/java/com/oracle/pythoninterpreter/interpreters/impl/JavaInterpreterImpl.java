package com.oracle.pythoninterpreter.interpreters.impl;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;
import com.oracle.pythoninterpreter.interpreters.CodeInterpreter;


public class JavaInterpreterImpl implements CodeInterpreter {
	
	private static final String JAVA_INTERPRETER_NOT_YES_IMPLEMENTED = "java interpreter not yes implemented !";
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) {
		// to be changed
		ExecutionResult executionResult = new ExecutionResult();
		executionResult.setResult(JAVA_INTERPRETER_NOT_YES_IMPLEMENTED);
		return executionResult;
	}
}
