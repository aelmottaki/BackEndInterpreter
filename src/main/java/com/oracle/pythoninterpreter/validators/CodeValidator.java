package com.oracle.pythoninterpreter.validators;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.Code;

public interface CodeValidator {
    void validate(Code code) throws CodeFormatException;
}
