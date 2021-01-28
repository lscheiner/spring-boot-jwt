package br.com.scheiner.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

	@ApiModelProperty(
			  value = "Id usuário",
			  name = "id",
			  dataType = "Long",
			  example = "1")
	 private Long id;
	 
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "username",
			  dataType = "String",
			  example = "teste")
	 private String username;
	
}
