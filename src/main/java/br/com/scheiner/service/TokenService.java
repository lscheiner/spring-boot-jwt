package br.com.scheiner.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
	
	public String gerarToken(Authentication authentication);

}
