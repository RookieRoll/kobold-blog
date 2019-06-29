package koboldblogprovider.koboldblogprovider.service;

import dto.dtos.UserDto;
import koboldblogprovider.koboldblogprovider.dao.User;
import koboldblogprovider.koboldblogprovider.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<UserDto> getUserList() {
		List<User> users=userMapper.getUsers();
		List<UserDto> userDtos=new ArrayList<>();
		users.forEach(m->{
			userDtos.add(m.convertToDto());
		});
		return userDtos;
	}

	@Override
	public UserDto findbyUsername(String username) {
		User user=userMapper.findbyUsername(username);
		return user.convertToDto();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean insertUser(UserDto userDto) {
		userDto.setId(UUID.randomUUID().toString());
		User user=userMapper.findbyUsername(userDto.getUsername());
		if(user!=null){
			return false;
		}
		userMapper.insertUser(User.convertToDao(userDto));
		return true;
	}
}
