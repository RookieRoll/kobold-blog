package koboldblogweb.koboldblogweb.service;

import dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Reference
	private UserService userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto dto=userService.findbyUsername(username);
		if(dto==null){
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
		return new User(dto.getUsername(), dto.getPassword(),new ArrayList<>());
	}
}
