package koboldblogweb.koboldblogweb.controller.webcontroller;

import dto.dtos.BlogStatus;
import dto.dtos.BlogsDto;
import koboldblogweb.koboldblogweb.utils.UserUtils;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogByClassifyId;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogCreateRequest;
import koboldblogweb.koboldblogweb.viewmodel.request.blogs.BlogsByStatus;
import koboldblogweb.koboldblogweb.viewmodel.response.BlogsListResponse;
import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BlogService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/blogs")
public class BlogsController {

	@Autowired
	private UserUtils userUtils;
	@Autowired
	private BlogService blogService;


	@GetMapping("/getblogs")
	public CommonResponse<?> getBlogsByStatus(@RequestBody BlogsByStatus status) {
		List<BlogsDto> source=blogService.getBlogsByStatus(userUtils.getUserId(), status.getBlogStatus(), status.getPageIndex(), status.getPageeSize());
		List<BlogsListResponse> result=source.stream().map(m->BlogsListResponse.convertToViewModel(m)).collect(Collectors.toList());
		return CommonResponse.ok(result);
	}

	@GetMapping("/getblogsbyclassify")
	public CommonResponse<?> getByClassifyId(@RequestBody BlogByClassifyId classifyId) {
		List<BlogsDto> source=blogService.getByClassifyId(userUtils.getUserId(), classifyId.getClassifyId(), classifyId.getPageIndex(), classifyId.getPageeSize());
		List<BlogsListResponse> result=source.stream().map(m->BlogsListResponse.convertToViewModel(m)).collect(Collectors.toList());
		return CommonResponse.ok(result);
	}

	@PostMapping("/insert")
	public CommonResponse<?> insertBlogs(@RequestBody BlogCreateRequest request) {
		blogService.insertBlog(request.convertToDto(userUtils.getUserId()));
		return CommonResponse.ok(true);
	}

}
