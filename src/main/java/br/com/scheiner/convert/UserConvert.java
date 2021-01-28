package br.com.scheiner.convert;

import org.springframework.stereotype.Component;

import br.com.scheiner.controller.form.UserForm;
import br.com.scheiner.entity.User;
import br.com.scheiner.utils.ConvertUtil;

@Component
public class UserConvert implements ConvertUtil<UserForm, User> {

	@Override
	public User convert(UserForm object) {
		return User.builder()
				.email(object.getEmail())
				.name(object.getName())
				.password(object.getPassword())
				.email(object.getEmail())
				.username(object.getUsername())
				.build();
	}

	

}
