package br.com.scheiner.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { BadCredentialsException.class, AuthenticationException.class })
	public ResponseEntity<Object> loginException(Exception exception) {
		ErrorDetails errorDetails = ErrorDetails.builder().message(exception.getLocalizedMessage()).status(HttpStatus.UNAUTHORIZED).errors(Arrays.asList("Usuário ou senha inválidos")).build();
		return new ResponseEntity<>(errorDetails,HttpStatus.UNAUTHORIZED);
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorDetails errorDetails = ErrorDetails.builder().message(ex.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST).errors(errorList).build();
        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
    }
}
