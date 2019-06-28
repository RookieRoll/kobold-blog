package koboldblogprovider.koboldblogprovider.service;

import dto.BlogStatus;
import dto.BlogsDto;
import koboldblogprovider.koboldblogprovider.dao.Blogs;
import koboldblogprovider.koboldblogprovider.mapper.BlogsMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.BlogService;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service(interfaceClass = BlogService.class)
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogsMapper blogsMapper;

	@Override
	public List<BlogsDto> getBlogsByStatus(String userId, BlogStatus blogstatus) {
		return blogsMapper.getBlogsByStatus(userId, blogstatus).stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<BlogsDto> getByClassifyId(String userId, String classifyid) {
		return blogsMapper.getByClassifyId(userId, classifyid).stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
	}

	@Override
	public void updateBlogsStatus(String id, String userId, String blogStatus) {
		blogsMapper.updateBlogsStatus(id, userId, blogStatus);
	}

	@Override
	public void deleteBlogs(String id, boolean isDeleted, String userId) {
		blogsMapper.deleteBlogs(id, isDeleted, userId);
	}

	@Override
	public void insertBlog(BlogsDto dto) {
		Blogs blog = (Blogs) Blogs.convertToDao(dto, Blogs.class);
		blog.setId(UUID.randomUUID().toString());
		blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
		blog.setModifyTime(new Timestamp(System.currentTimeMillis()));
		blogsMapper.insertBlog(blog);
	}

	@Override
	public void updateBlog(BlogsDto dto) {
		Blogs blog = (Blogs) Blogs.convertToDao(dto, Blogs.class);
		blog.setModifyTime(new Timestamp(System.currentTimeMillis()));
		blogsMapper.updateBlog(blog);
	}
}
