package br.com.scheiner.controller.auth;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import br.com.scheiner.exception.ErrorDetails;
import br.com.scheiner.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(SecurityConstants.USER_LOGIN)
public class AuthenticationController {

	private AuthenticationManager authManager;

	private TokenService tokenService;
	 
	@Operation(description = "Autenticação",
	    extensions = @Extension(properties = {
	    			 @ExtensionProperty(name = "code-samples", value = "[{\"lang\":\"curl\",\"source\":\"curl <URL>?queryparam=example\"} ,"
	            												+ "{\"lang\":\"Java\",\"source\":\"curl <URL>?queryparam=example\"} ]", 
	            												parseValue = true)
	    })
	)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Login com sucesso",
		    		content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE , schema = @Schema(implementation = String.class ))),
		    @ApiResponse(responseCode = "400", description = "Erro de validação" ,
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class))),
		    @ApiResponse(responseCode = "401", description = "Não autorizado",
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class))),
		    @ApiResponse(responseCode = "500", description = "Erro interno",
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class)))
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	@SecurityRequirements
	public ResponseEntity<String> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		return ResponseEntity.ok(this.tokenService.gerarToken(this.authManager.authenticate(dadosLogin)));
		
	
	}

}