package br.com.scheiner.controller.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserForm {
	
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "username",
			  dataType = "String",
			  example = "teste")
	private String username;
	
	@ApiModelProperty(
			  value = "Senha do usuário",
			  name = "password",
			  dataType = "String",
			  example = "12345678")
	private String password;
	
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "name",
			  dataType = "String",
			  example = "Teste da Silva")
	private String name;
	
	
	@ApiModelProperty(
			  value = "Email do usuário",
			  name = "email",
			  dataType = "String",
			  example = "teste@teste.com.br")
	private String email;

}
