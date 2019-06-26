package koboldblogweb.koboldblogweb.controller;

import dto.UserDto;
import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Value("${username}")
	private String name;

	@GetMapping("/getname")
	public CommonResponse<?> getName(){
		return CommonResponse.ok(name);
	}
	@GetMapping("/get")
	public CommonResponse<?> get(){
		return  CommonResponse.ok(userService.getUserList());
	}

}
