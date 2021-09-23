package br.com.scheiner.controller.user;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.config.SecurityConstants;
import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.controller.form.UserForm;
import br.com.scheiner.service.UserServices;
import br.com.scheiner.utils.UrlUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags = "user")
public class CreateUserController {

	private UserServices userServices;

	@ApiOperation(value = "Criação de usuário")
	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
		    @ApiResponse(code = 400, message = "Erro de validação"),
		    @ApiResponse(code = 500, message = "Erro interno")
	})
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(SecurityConstants.USER_API)
	public ResponseEntity<String> createUser(@RequestBody @Valid UserForm userForm) {

		UserDto user = this.userServices.createUser(userForm);
	    return ResponseEntity.created(UrlUtils.createUrl(user.getId())).build();	
	 }
}
