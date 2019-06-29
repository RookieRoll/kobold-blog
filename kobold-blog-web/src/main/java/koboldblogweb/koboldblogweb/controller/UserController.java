package koboldblogweb.koboldblogweb.controller;

import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/get")
	public CommonResponse<?> get(){
		return  CommonResponse.ok(userService.getUserList());
	}

}
