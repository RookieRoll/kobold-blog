package service;

import dto.dtos.BlogStatus;
import dto.dtos.BlogsDto;

import java.util.List;

public interface BlogService {
	List<BlogsDto> getBlogsByStatus(String userId, BlogStatus blogstatus);
	List<BlogsDto> getByClassifyId(String userId,String classifyid);
	void updateBlogsStatus(String id,String userId,BlogStatus blogStatus);
	void deleteBlogs(String id,boolean isDeleted,String userId);
	void insertBlog(BlogsDto blog);
	void updateBlog(BlogsDto blogs);
}
