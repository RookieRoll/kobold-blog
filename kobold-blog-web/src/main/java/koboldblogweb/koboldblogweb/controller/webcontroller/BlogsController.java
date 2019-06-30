package koboldblogweb.koboldblogweb.controller.webcontroller;

import dto.dtos.BlogStatus;
import koboldblogweb.koboldblogweb.utils.UserUtils;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogByClassifyId;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogCreateRequest;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogsByStatus;
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
    public CommonResponse<?> getBlogsByStatus(@RequestBody BlogsByStatus status) {
        return CommonResponse.ok(blogService.getBlogsByStatus(userUtils.getUserId(), status.getBlogStatus(), status.getPageIndex(), status.getPageeSize()));
    }

    @GetMapping("/getblogsbyclassify")
    public CommonResponse<?> getByClassifyId(@RequestBody BlogByClassifyId classifyId) {
        return CommonResponse.ok(blogService.getByClassifyId(userUtils.getUserId(), classifyId.getClassifyId(), classifyId.getPageIndex(), classifyId.getPageeSize()));
    }

    public CommonResponse<?> insetBlogs(@RequestBody BlogCreateRequest request) {
        blogService.insertBlog(request.convertToDto(userUtils.getUserId()));
        return CommonResponse.ok(true);
    }

}
