package com.oracle.pythoninterpreter.parsers.impl;

import com.oracle.pythoninterpreter.parsers.LangPrefixPicker;
import com.oracle.pythoninterpreter.pojos.Code;

public class LangPrefixPickerImpl implements LangPrefixPicker
{
    private static final String REGEX = " ";

    @Override
    public String getPrefix(Code code) {
        return code.getCode().split(REGEX)[0];
    }

}
