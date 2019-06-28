package koboldblogweb.koboldblogweb.service;

import dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto dto=userService.findbyUsername(username);
		if(dto==null){
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
		List<GrantedAuthority> list= new ArrayList<>();
		list.add(new SimpleGrantedAuthority("Admin"));

		return new User(dto.getUsername(), dto.getPassword(),list);
	}
}
