package koboldblogweb.koboldblogweb.controller.webcontroller;

import koboldblogweb.koboldblogweb.annotations.AuthTypeAnnotation;
import koboldblogweb.koboldblogweb.utils.UserUtils;
import koboldblogweb.koboldblogweb.viewmodel.request.PagerInfoModel;
import koboldblogweb.koboldblogweb.viewmodel.request.classifies.ClassifyModifyRequest;
import koboldblogweb.koboldblogweb.viewmodel.request.classifies.ClassifyStatusRequest;
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
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> insertClassify(@RequestBody ClassifyModifyRequest request) {
        classifyService.insertClassify(request.convertToDto(userUtils.getUserId()));
        return CommonResponse.ok(true);
    }

    @GetMapping("/getclassify")
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> getUsedClassify(@RequestBody PagerInfoModel requestModel) {
        return CommonResponse.ok(classifyService.getUsedClassify(userUtils.getUserId(), requestModel.getPageIndex(), requestModel.getPageeSize()));
    }

    @GetMapping("/getallClassifies")
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> getAllClassify(@RequestBody PagerInfoModel requestModel) {
        return CommonResponse.ok(classifyService.getAllClassify(userUtils.getUserId(), requestModel.getPageIndex(), requestModel.getPageeSize()));
    }

    @PostMapping("/getclassifybyid")
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> getClassifyById(@RequestBody String id) {
        return CommonResponse.ok(classifyService.getClassifyById(id, userUtils.getUserId()));
    }

    @PostMapping("/stop")
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> stopClassifyById(@RequestBody ClassifyStatusRequest request) {
        classifyService.stopClassifyById(request.isStopped(), request.getId(), userUtils.getUserId());
        return CommonResponse.ok(true);
    }

    @PostMapping("/delete")
    @AuthTypeAnnotation("Admin")
    public CommonResponse<?> deleteClassify(@RequestBody String id) {
        classifyService.deleteClassifyById(userUtils.getUserId(), id);
        return CommonResponse.ok(true);
    }

}


