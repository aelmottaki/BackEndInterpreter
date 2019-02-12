package com.oracle.pythoninterpreter.validators.impl;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.Code;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodeValidatorImplTest {

    @Test(expected = CodeFormatException.class)
    public void shouldThrowCodeFormatException() throws CodeFormatException {
        CodeValidatorImpl codeValidator = new CodeValidatorImpl("%[a-zA-Z]{3,10}\\s.*");
        Code code = new Code();
        code.setCode("python print()");
        codeValidator.validate(code);
    }

}