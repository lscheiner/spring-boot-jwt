package br.com.scheiner.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.config.SecurityConstants;
import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.controller.form.UserForm;
import br.com.scheiner.exception.ErrorDetails;
import br.com.scheiner.service.UserServices;
import br.com.scheiner.utils.UrlUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(SecurityConstants.USER_API)
public class UserController {

	private UserServices userServices;
	
	
	@Operation(description  = "Criação de usuário")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso",
		    		content = @Content(schema = @Schema(implementation = Void.class))),
		    @ApiResponse(responseCode = "400", description = "Erro de validação", 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class))),
		    @ApiResponse(responseCode = "500", description = "Erro interno",
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class)))
	})
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	@SecurityRequirements
	public ResponseEntity<String> createUser(@RequestBody @Valid UserForm userForm) {

		UserDto user = this.userServices.createUser(userForm);
	    return ResponseEntity.created(UrlUtils.createUrl(user.getId())).build();	
	 }
	

	@Operation( description  = "Lista todos os usuários")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Lista Usuários" , 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
		    @ApiResponse(responseCode = "403", description = "Acesso negado" , 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class))),
		    @ApiResponse(responseCode = "500", description = "Erro interno", 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE , schema = @Schema(implementation = ErrorDetails.class))),
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<UserDto>> list() {
		return ResponseEntity.ok(this.userServices.list());
	}

}
