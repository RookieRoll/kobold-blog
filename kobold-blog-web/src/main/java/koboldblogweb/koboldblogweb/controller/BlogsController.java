package koboldblogweb.koboldblogweb.controller;

import dto.dtos.BlogStatus;
import koboldblogweb.koboldblogweb.utils.UserUtils;
import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BlogService;

@RequestMapping("/api/blogs")
public class BlogsController {

    @Autowired
    private UserUtils userUtils;
    @Autowired
    private BlogService blogService;


    @GetMapping("/getblogs")
    public CommonResponse<?> getBlogsByStatus(@RequestBody BlogStatus status){
        return CommonResponse.ok(blogService.getBlogsByStatus(userUtils.getUserId(),status));
    }

    @GetMapping("/getblogsbyclassify")
    public CommonResponse<?> getByClassifyId(@RequestBody String classifyId){
        return CommonResponse.ok(blogService.getByClassifyId(userUtils.getUserId(),classifyId));
    }

}
