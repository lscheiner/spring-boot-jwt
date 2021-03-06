package br.com.scheiner.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.config.SecurityConstants;
import br.com.scheiner.controller.form.LoginForm;
import br.com.scheiner.service.TokenService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(SecurityConstants.USER_LOGIN)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Login efetuado com sucesso"),
		    @ApiResponse(code = 400, message = "Erro na validação"),
		    @ApiResponse(code = 401, message = "Não autorizado"),
		    @ApiResponse(code = 500, message = "Erro genérico"),
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		return ResponseEntity.ok(this.tokenService.gerarToken(this.authManager.authenticate(dadosLogin)));
		
	
	}

}