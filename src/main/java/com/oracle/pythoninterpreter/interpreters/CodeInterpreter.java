package com.oracle.pythoninterpreter.interpreters;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;

public interface CodeInterpreter {
	 ExecutionResult execute(Code code) throws CodeFormatException;
}
