package com.oracle.pythoninterpreter.validators.impl;

import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.validators.CodeValidator;
import org.apache.commons.lang.StringUtils;

public class CodeValidatorImpl implements CodeValidator{

    private String regexFormat; // default value to change it in config spring

    public CodeValidatorImpl(String regexFormat){
        this.regexFormat = regexFormat;
    }
    @Override
    public void validate(Code code) throws CodeFormatException {
        if(StringUtils.isEmpty(code.getCode()) || codeHasBadFormat(code.getCode())){
            throw new CodeFormatException();
        }
    }
    private boolean codeHasBadFormat(String code) {
        return !code.matches(regexFormat);
    }
}
