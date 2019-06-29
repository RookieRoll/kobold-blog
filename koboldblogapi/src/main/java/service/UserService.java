package service;

import dto.dtos.UserDto;

import java.util.List;

/**
 * @author RWX
 */
public interface UserService {
	List<UserDto> getUserList();
	UserDto findbyUsername(String username);
	Boolean insertUser(UserDto userDto);
}
