package br.com.scheiner.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "UserData", description="Descrição do usuário")
public class UserDto {

	@Schema(
			  description = "Id usuário",
			  name = "id",
			  example = "1")
	 private Long id;
	 
	@Schema(
			description = "Nome do usuário",
			  name = "username",
			  example = "teste")
	 private String username;
	
}
