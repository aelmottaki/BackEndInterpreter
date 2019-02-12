package com.oracle.pythoninterpreter.controllers;


import com.oracle.pythoninterpreter.exceptions.CodeFormatException;
import com.oracle.pythoninterpreter.pojos.ErrorDetails;
import org.python.core.PyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import java.util.Date;

@ControllerAdvice
@RestController
public class ErrorController {
	
	public static final String CODE_FORMAT_ERROR_CHECK_CONTRACT_FORMAT_PLEASE = "Code Format Error ! check specified format please .";
	public static final String CODE_SYNTAX_ERROR_CHECK_YOUR_CODE_PLEASE = "Code Syntax error ! check your code please .";
	private static final String YOUR_CODE_TAKE_A_LOT_OF_TIME_TO_BE_EXECUTED = "Your code take a lot of time to be executed !";
	
	@ExceptionHandler(CodeFormatException.class)
	public final ResponseEntity<ErrorDetails> handleCodeFormatException(CodeFormatException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), CODE_FORMAT_ERROR_CHECK_CONTRACT_FORMAT_PLEASE,
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PyException.class)
	public final ResponseEntity<ErrorDetails> handleCodeSyntaxException(PyException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), CODE_SYNTAX_ERROR_CHECK_YOUR_CODE_PLEASE,
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AsyncRequestTimeoutException.class)
	public final ResponseEntity<ErrorDetails> handleTimeoutException(AsyncRequestTimeoutException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), YOUR_CODE_TAKE_A_LOT_OF_TIME_TO_BE_EXECUTED,
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.REQUEST_TIMEOUT);
	}
}
