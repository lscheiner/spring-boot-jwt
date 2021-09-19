package br.com.scheiner.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.controller.form.UserForm;
import br.com.scheiner.convert.UserConvert;
import br.com.scheiner.convert.UserDtoConvert;
import br.com.scheiner.entity.User;
import br.com.scheiner.repository.UserRepository;
import br.com.scheiner.service.UserServices;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices {

	private UserRepository userRepository;

	private PasswordEncoder encoder;

	private UserConvert userConvert;
	
	private UserDtoConvert userDtoConvert;

	@Override
	public UserDto createUser(UserForm userForm) {
		userForm.setPassword(encoder.encode(userForm.getPassword()));
		User user = userConvert.convert(userForm);
		return this.userDtoConvert.apply(this.userRepository.save(user));
	}

	@Override
	public List<UserDto> list() {
		return this.userRepository.findAll().stream().map(this.userDtoConvert).collect(Collectors.toList());
	}
}
