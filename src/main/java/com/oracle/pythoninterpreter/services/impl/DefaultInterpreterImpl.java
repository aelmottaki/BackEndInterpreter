package com.oracle.pythoninterpreter.services.impl;

import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;
import com.oracle.pythoninterpreter.services.CodeInterpreter;


public class DefaultInterpreterImpl implements CodeInterpreter {
	
	private static final String CODE_CAN_T_BE_INTERPRETED = "default interpreter not yes implemented !";
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) {
		// to change this default implementation
		ExecutionResult executionResult = new ExecutionResult();
		executionResult.setResult(CODE_CAN_T_BE_INTERPRETED);
		return executionResult;
	}

}
