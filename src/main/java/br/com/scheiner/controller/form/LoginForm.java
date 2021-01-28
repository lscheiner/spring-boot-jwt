package br.com.scheiner.controller.form;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginForm {

	@ApiModelProperty(
			  value = "Nome do usuário",
			  name = "username",
			  dataType = "String",
			  example = "teste")
    @NotBlank(message = "Usuário obrigatório")
	private String username;
	
	@ApiModelProperty(
			  value = "Senha do usuário",
			  name = "password",
			  dataType = "String",
			  example = "12345678")
	@NotBlank(message = "Senha é obrigatória")
	private String password;
	
	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
}
