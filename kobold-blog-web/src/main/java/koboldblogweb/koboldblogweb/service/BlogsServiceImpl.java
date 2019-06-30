package koboldblogweb.koboldblogweb.service;

import dto.dtos.BlogStatus;
import dto.dtos.BlogsDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import service.BlogService;

import java.util.List;

@Service
public class BlogsServiceImpl implements BlogService {
	@Reference
	private BlogService blogService;

	@Override
	public List<BlogsDto> getBlogsByStatus(String userId, BlogStatus blogstatus,int pageIndex,int pageSize) {
		return blogService.getBlogsByStatus(userId, blogstatus,pageIndex,pageSize);
	}

	@Override
	public List<BlogsDto> getByClassifyId(String userId, String classifyid,int pageIndex,int pageSize) {
		return blogService.getByClassifyId(userId, classifyid,pageIndex,pageSize);
	}

	@Override
	public void updateBlogsStatus(String id, String userId, BlogStatus blogStatus) {
		blogService.updateBlogsStatus(id, userId, blogStatus);
	}

	@Override
	public void deleteBlogs(String id, boolean isDeleted, String userId) {
		blogService.deleteBlogs(id, isDeleted, userId);
	}

	@Override
	public void insertBlog(BlogsDto blog) {
		blogService.insertBlog(blog);
	}

	@Override
	public void updateBlog(BlogsDto blogs) {
		blogService.updateBlog(blogs);
	}
}
