package br.com.scheiner.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="UserForm", description="Cadastro de usuário")
public class UserForm {
	
	@Schema(
			  description = "Nome do usuário",
			  name = "username",
			  example = "teste")
	private String username;
	
	@Schema(
			  description = "Senha do usuário",
			  name = "password",
			  example = "12345678")
	private String password;
	
	@Schema(
			  description = "Nome do usuário",
			  name = "name",
			  example = "Teste da Silva")
	private String name;
	
	
	@Schema(
			  description = "Email do usuário",
			  name = "email",
			  example = "teste@teste.com.br")
	private String email;

}
