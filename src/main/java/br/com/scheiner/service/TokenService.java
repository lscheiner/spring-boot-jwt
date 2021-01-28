package br.com.scheiner.service;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.scheiner.config.SecurityConstants;
import br.com.scheiner.entity.User;

@Service
public class TokenService {
	public String gerarToken(Authentication authentication) {
		
		String token = JWT.create()
                .withSubject(((User) authentication.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
		
		return token;
	}

}
