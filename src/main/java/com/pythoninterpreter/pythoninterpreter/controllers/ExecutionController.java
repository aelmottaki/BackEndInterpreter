package com.pythoninterpreter.pythoninterpreter.controllers;


import com.pythoninterpreter.pythoninterpreter.pojos.CodeToBeExecuted;
import com.pythoninterpreter.pythoninterpreter.pojos.ExecutionResult;
import com.pythoninterpreter.pythoninterpreter.services.impl.InterpreterFactory;
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
	public Callable<ExecutionResult> execute(@RequestBody CodeToBeExecuted codeToBeExecuted, HttpSession httpSession){
		return ()-> interpreterFactory.getInterpreter(codeToBeExecuted).execute(codeToBeExecuted);
	}
}
