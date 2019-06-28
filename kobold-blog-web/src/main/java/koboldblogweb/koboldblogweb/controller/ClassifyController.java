package koboldblogweb.koboldblogweb.controller;

import koboldblogweb.koboldblogweb.utils.UserUtils;
import koboldblogweb.koboldblogweb.viewmodel.request.ClassifyModifyRequest;
import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClassifyService;

@RestController
@RequestMapping("/api/classify")
public class ClassifyController {
	@Autowired
	private ClassifyService classifyService;

	@Autowired
	private UserUtils userUtils;

	@PostMapping("/insert")
	public CommonResponse<?> insertClassify(@RequestBody ClassifyModifyRequest request) {
		classifyService.insertClassify(request.convertToDto(userUtils.getUserId()));
		return CommonResponse.ok(true);
	}

	@GetMapping("/getclassify")
	public CommonResponse<?> getUsedClassify() {
		return CommonResponse.ok(classifyService.getUsedClassify(userUtils.getUserId()));
	}

}
