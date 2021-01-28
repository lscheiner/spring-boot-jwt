package br.com.scheiner.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDetails {
	private HttpStatus status;
	private String message;
	private List<String> errors;

}
