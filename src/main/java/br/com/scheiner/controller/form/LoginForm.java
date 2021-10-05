package br.com.scheiner.controller.form;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="Login", description="form de login")
public class LoginForm {

	@Schema(
			description = "Nome do usuário",
			  name = "username",
			  example = "teste")
    @NotBlank(message = "Usuário obrigatório")
	private String username;
	
	@Schema(
			  description = "Senha do usuário",
			  name = "password",
			  example = "12345678")
	@NotBlank(message = "Senha é obrigatória")
	private String password;
	
	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(this.username, this.password);
	}
}
