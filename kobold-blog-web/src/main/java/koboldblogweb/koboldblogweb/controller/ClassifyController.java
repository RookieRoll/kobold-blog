package koboldblogweb.koboldblogweb.controller;

import koboldblogweb.koboldblogweb.annotations.AuthTypeAnnotation;
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
	@AuthTypeAnnotation("Admin")
	public CommonResponse<?> getUsedClassify() {
		return CommonResponse.ok(classifyService.getUsedClassify(userUtils.getUserId()));
	}

	@GetMapping("/getallClassifies")
	@AuthTypeAnnotation("Admin")
	public CommonResponse<?>  getAllClassify(){
		return CommonResponse.ok(classifyService.getAllClassify(userUtils.getUserId()));
	}

	@PostMapping("/getclassifybyid")
	public CommonResponse<?> getClassifyById(@RequestBody  String id){
		return CommonResponse.ok(classifyService.getClassifyById(id,userUtils.getUserId()));
	}


}
