package com.pythoninterpreter.pythoninterpreter.services.impl;

import com.pythoninterpreter.pythoninterpreter.exceptions.CodeFormatException;
import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;
import com.pythoninterpreter.pythoninterpreter.pojos.ExecutionResult;
import com.pythoninterpreter.pythoninterpreter.services.CodeFormatter;
import com.pythoninterpreter.pythoninterpreter.services.CodeInterpreter;
import org.python.util.PythonInterpreter;

import java.io.ByteArrayOutputStream;


public class PythonInterpreterImpl implements CodeInterpreter {
	
	private PythonInterpreter pythonInterpreter;
	
	private CodeFormatter codeFormatter;
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pythonInterpreter.setOut(baos);
		pythonInterpreter.exec(codeFormatter.format(codeToBeExecuted));
		ExecutionResult executionResult = new ExecutionResult();
		executionResult.setResult(new String(baos.toByteArray()).trim());
		return executionResult;
	}
	
	public PythonInterpreter getPythonInterpreter() {
		return pythonInterpreter;
	}
	
	public void setPythonInterpreter(PythonInterpreter pythonInterpreter) {
		this.pythonInterpreter = pythonInterpreter;
	}
	
	public CodeFormatter getCodeFormatter() {
		return codeFormatter;
	}
	
	public void setCodeFormatter(CodeFormatter codeFormatter) {
		this.codeFormatter = codeFormatter;
	}
}
