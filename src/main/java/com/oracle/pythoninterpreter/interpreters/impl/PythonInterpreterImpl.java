package com.oracle.pythoninterpreter.interpreters.impl;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.parsers.CodeExtractor;
import com.oracle.pythoninterpreter.pojos.CodeToBeExecuted;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;
import com.oracle.pythoninterpreter.interpreters.CodeInterpreter;
import org.python.util.PythonInterpreter;

import java.io.ByteArrayOutputStream;


public class PythonInterpreterImpl implements CodeInterpreter {
	
	private PythonInterpreter pythonInterpreter;
	
	private CodeExtractor codeExtractor;
	
	@Override
	public ExecutionResult execute(CodeToBeExecuted codeToBeExecuted) throws CodeFormatException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pythonInterpreter.setOut(baos);
		pythonInterpreter.exec(codeExtractor.format(codeToBeExecuted));
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
	
	public CodeExtractor getCodeFormatter() {
		return codeExtractor;
	}
	
	public void setCodeExtractor(CodeExtractor codeExtractor) {
		this.codeExtractor = codeExtractor;
	}
}
