package service;

import dto.UserDto;

import java.util.List;

/**
 * @author RWX
 */
public interface UserService {
	List<UserDto> getUserList();
	UserDto findbyUsername(String username);
	Boolean insertUser(UserDto userDto);
}
