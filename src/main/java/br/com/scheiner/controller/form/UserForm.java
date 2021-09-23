package br.com.scheiner.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="UserForm", description="Cadastro de usuário")
public class UserForm {
	
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "username",
			  example = "teste")
	private String username;
	
	@ApiModelProperty(
			  value = "Senha do usuário",
			  name = "password",
			  example = "12345678")
	private String password;
	
	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "name",
			  example = "Teste da Silva")
	private String name;
	
	
	@ApiModelProperty(
			  value = "Email do usuário",
			  name = "email",
			  example = "teste@teste.com.br")
	private String email;

}
