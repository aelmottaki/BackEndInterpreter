package com.oracle.pythoninterpreter.parsers;

import com.oracle.pythoninterpreter.parsers.impl.LangPrefixPickerImpl;
import com.oracle.pythoninterpreter.pojos.Code;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class LangPrefixPickerTest {

    @Test
    public void shouldReturnPrefix(){
        LangPrefixPickerImpl langPrefixPicker = new LangPrefixPickerImpl();
        Code code = new Code();
        code.setCode("%python print('hello')");
        Assertions.assertThat(langPrefixPicker.getPrefix(code)).isEqualToIgnoringCase("%python");
    }



}