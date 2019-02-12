package com.oracle.pythoninterpreter.parsers;

import com.oracle.pythoninterpreter.pojos.Code;

public interface LangPrefixPicker {
    String getPrefix(Code code);
}
