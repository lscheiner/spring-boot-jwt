package br.com.scheiner.controller.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.config.SecurityConstants;
import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.service.UserServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(SecurityConstants.API)
@Api(tags = "user")
public class UserController {

	private UserServices userServices;

	@ApiOperation(value = "Lista todos os usuários")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Lista Usuários"),
		    @ApiResponse(code = 403, message = "Acesso negado"),
		    @ApiResponse(code = 500, message = "Erro interno"),
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(SecurityConstants.USER_API)
	public ResponseEntity<List<UserDto>> list() {
		return ResponseEntity.ok(this.userServices.list());
	}

}
