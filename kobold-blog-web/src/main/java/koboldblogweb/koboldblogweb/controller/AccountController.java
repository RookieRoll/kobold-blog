package koboldblogweb.koboldblogweb.controller;

import dto.UserDto;
import io.swagger.annotations.Api;
import koboldblogweb.koboldblogweb.config.JwtTokenUtil;
import koboldblogweb.koboldblogweb.service.JwtUserDetailsService;
import koboldblogweb.koboldblogweb.viewmodel.request.LoginRequest;
import koboldblogweb.koboldblogweb.viewmodel.request.RegisterRequest;
import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

/**
 * @author RWX
 */
@RestController
@Api(tags = "登录")
public class AccountController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Reference
	private UserService userService;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@PostMapping("/signin")
	public CommonResponse<?> login(@RequestBody @Validated LoginRequest loginRequest) throws Exception {
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		authenticationManager.authenticate(authentication);

		final UserDto user =userService.findbyUsername(loginRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return CommonResponse.ok(token);
	}

	@PostMapping("/signup")
	public CommonResponse<?> register(@RequestBody @Validated RegisterRequest request) {
		request.setPassword(bcryptEncoder.encode(request.getPassword()));
		Boolean result = userService.insertUser(request.convertToDto());
		CommonResponse response = new CommonResponse(HttpStatus.OK, result);
		if (!result) {
			response.setMessage("用户名重复，请重新输入");
		}
		return CommonResponse.ok(result);
	}


}