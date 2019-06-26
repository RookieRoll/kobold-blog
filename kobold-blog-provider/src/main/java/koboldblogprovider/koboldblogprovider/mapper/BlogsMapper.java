package koboldblogprovider.koboldblogprovider.mapper;

import dto.BlogStatus;
import koboldblogprovider.koboldblogprovider.dao.Blogs;

import java.util.List;

public interface BlogsMapper {
	/**
	 *
	 * @param userId
	 * @param blogstatus
	 * @return
	 */
	List<Blogs> getBlogsByStatus(String userId, BlogStatus blogstatus);

	List<Blogs> getByClassifyId(String userId,String classifyid);

	void updateBlogsStatus(String id,String userId,String blogStatus);
	void deleteBlogs(String id,boolean isDeleted,String userId);
	void insertBlog(Blogs blog);
	void updateBlog(Blogs blogs);
}
