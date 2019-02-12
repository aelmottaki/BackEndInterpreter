package com.oracle.pythoninterpreter.controllers;


import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;
import com.oracle.pythoninterpreter.interpreters.impl.InterpreterFactory;
import com.oracle.pythoninterpreter.validators.CodeValidator;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController("executionController")
public class ExecutionController {
	@Resource(name = "interpreterFactory")
	private InterpreterFactory interpreterFactory;

	@Resource(name = "codeValidator")
	private CodeValidator codeValidator;

	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/execute")
	public Callable<ExecutionResult> execute(@RequestBody Code code, HttpSession httpSession){
		return ()-> {
			codeValidator.validate(code);
			return interpreterFactory.getInterpreter(code).execute(code);
			};
	}
}
