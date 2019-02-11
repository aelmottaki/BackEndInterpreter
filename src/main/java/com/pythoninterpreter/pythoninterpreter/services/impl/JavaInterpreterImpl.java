package com.pythoninterpreter.pythoninterpreter.services.impl;

import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;
import com.pythoninterpreter.pythoninterpreter.pojos.ExecutionResult;
import com.pythoninterpreter.pythoninterpreter.services.CodeInterpreter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component("javaInterpreterImpl")
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.INTERFACES)
public class JavaInterpreterImpl implements CodeInterpreter {
	
	public static final String JAVA_INTERPRETER_NOT_YES_IMPLEMENTED = "java interpreter not yes implemented !";
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) {
		// to be changed
		ExecutionResult executionResult = new ExecutionResult();
		executionResult.setResult(JAVA_INTERPRETER_NOT_YES_IMPLEMENTED);
		return executionResult;
	}
}
