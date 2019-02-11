package com.pythoninterpreter.pythoninterpreter.services.impl;

import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;
import com.pythoninterpreter.pythoninterpreter.pojos.ExecutionResult;
import com.pythoninterpreter.pythoninterpreter.services.CodeInterpreter;


public class DefaultInterpreterImpl implements CodeInterpreter {
	
	public static final String CODE_CAN_T_BE_INTERPRETED = "default interpreter not yes implemented !";
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) {
		// to change this default implementation
		ExecutionResult executionResult = new ExecutionResult();
		executionResult.setResult(CODE_CAN_T_BE_INTERPRETED);
		return executionResult;
	}

}
