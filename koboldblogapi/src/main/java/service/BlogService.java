package service;

import dto.BlogStatus;
import dto.BlogsDto;

import java.util.List;

public interface BlogService {
	List<BlogsDto> getBlogsByStatus(String userId, BlogStatus blogstatus);
	List<BlogsDto> getByClassifyId(String userId,String classifyid);
	void updateBlogsStatus(String id,String userId,String blogStatus);
	void deleteBlogs(String id,boolean isDeleted,String userId);
	void insertBlog(BlogsDto blog);
	void updateBlog(BlogsDto blogs);
}
