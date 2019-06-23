package comexample.comexample.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Reference
	private UserService userService;

	public ResponseEntity<?> get() {
		return ResponseEntity.ok(userService.getUserList());
	}
}
