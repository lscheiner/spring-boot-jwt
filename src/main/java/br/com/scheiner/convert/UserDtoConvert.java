package br.com.scheiner.convert;

import org.springframework.stereotype.Component;

import br.com.scheiner.controller.dto.UserDto;
import br.com.scheiner.entity.User;
import br.com.scheiner.utils.ConvertUtil;

@Component
public class UserDtoConvert implements ConvertUtil<User, UserDto> {

	@Override
	public UserDto convert(User object) {
		return UserDto.builder()
				.id(object.getId())
				.username(object.getUsername())
				.build();
	}

}
