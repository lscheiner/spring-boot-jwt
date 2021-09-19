package br.com.scheiner.service;

import java.util.List;

import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.controller.form.UserForm;

public interface UserServices {

	public UserDto createUser(UserForm userForm);

	public List<UserDto> list();

}
