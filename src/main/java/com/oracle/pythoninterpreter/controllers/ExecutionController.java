package com.oracle.pythoninterpreter.controllers;


import com.oracle.pythoninterpreter.pojos.Code;
import com.oracle.pythoninterpreter.pojos.ExecutionResult;
import com.oracle.pythoninterpreter.interpreters.impl.InterpreterFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController("executionController")
public class ExecutionController {
	@Resource(name = "interpreterFactory")
	private InterpreterFactory interpreterFactory;

	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/execute")
	public Callable<ExecutionResult> execute(@RequestBody Code code, HttpSession httpSession){
		return ()-> interpreterFactory.getInterpreter(code).execute(code);
	}
}
