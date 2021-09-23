package br.com.scheiner.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value="UserDto", description="Descrição do usuário")
public class UserDto {

	@ApiModelProperty(
			  value = "Id usuário",
			  name = "id",
			  example = "1")
	 private Long id;
	 
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "username",
			  example = "teste")
	 private String username;
	
}
