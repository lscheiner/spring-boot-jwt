package br.com.scheiner.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.controller.form.UserForm;
import br.com.scheiner.convert.UserConvert;
import br.com.scheiner.convert.UserDtoConvert;
import br.com.scheiner.entity.User;
import br.com.scheiner.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserConvert userConvert;
	
	@Autowired
	private UserDtoConvert userDtoConvert;
	

	public UserDto createUser(UserForm userForm) {
		userForm.setPassword(encoder.encode(userForm.getPassword()));
		User user = userConvert.convert(userForm);
		return this.userDtoConvert.apply(this.userRepository.save(user));
	}

	public List<UserDto> list() {
		return this.userRepository.findAll().stream().map(userDtoConvert).collect(Collectors.toList());
	}
}
