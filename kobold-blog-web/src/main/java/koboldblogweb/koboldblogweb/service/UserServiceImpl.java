package koboldblogweb.koboldblogweb.service;

import dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Reference
	private UserService userService;

	@Override
	@Cacheable("getuserlist")
	public List<UserDto> getUserList() {
		return userService.getUserList();
	}

	@Override
	//@Cacheable("finduser")
	public UserDto findbyUsername(String username) {
		return userService.findbyUsername(username);
	}

	@Override
	public Boolean insertUser(UserDto userDto) {
		return userService.insertUser(userDto);
	}
}
