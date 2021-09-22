package br.com.scheiner.controller.auth;

import javax.validation.Valid;

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
import br.com.scheiner.swagger.annotation.CodeLangs;
import br.com.scheiner.swagger.annotation.CodeSample;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(SecurityConstants.USER_LOGIN)
public class AuthenticationController {

	private AuthenticationManager authManager;

	private TokenService tokenService;

	
	 @CodeSample(langs = {
	            @CodeLangs(lang = "Java", source= "System.out.println(\"TESTE\");"),
	            @CodeLangs(lang = "JavaScript", source= "var http = new XMLHttpRequest();\n" +
	                    "http.open('GET', 'http://localhost:8080/api', false);\n" +
	                    "http.send();\n" +
	                    "console.log(http.responseText);"),
	    })
	@ApiOperation(value = "Autentica")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Login com sucesso"),
		    @ApiResponse(code = 400, message = "Erro de validação"),
		    @ApiResponse(code = 401, message = "Não autorizado"),
		    @ApiResponse(code = 500, message = "Erro interno")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		return ResponseEntity.ok(this.tokenService.gerarToken(this.authManager.authenticate(dadosLogin)));
		
	
	}

}