package koboldblogprovider.koboldblogprovider.service;

import com.github.pagehelper.PageHelper;
import dto.dtos.BlogStatus;
import dto.dtos.BlogsDto;
import koboldblogprovider.koboldblogprovider.dao.Blogs;
import koboldblogprovider.koboldblogprovider.dao.ClassifyBlogs;
import koboldblogprovider.koboldblogprovider.mapper.BlogsMapper;
import koboldblogprovider.koboldblogprovider.mapper.ClassifyMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.BlogService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service(interfaceClass = BlogService.class)
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogsMapper blogsMapper;
	@Autowired
	private ClassifyMapper classifyMapper;

	@Override
	public List<BlogsDto> getBlogsByStatus(String userId, BlogStatus blogstatus,int pageIndex,int pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		return blogsMapper.getBlogsByStatus(userId, blogstatus).stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<BlogsDto> getByClassifyId(String userId, String classifyid,int pageIndex,int pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		return blogsMapper.getByClassifyId(userId, classifyid).stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
	}

	@Override
	public void updateBlogsStatus(String id, String userId, BlogStatus blogStatus) {
		blogsMapper.updateBlogsStatus(id, userId, blogStatus);
	}

	@Override
	public void deleteBlogs(String id, boolean isDeleted, String userId) {
		blogsMapper.deleteBlogs(id, isDeleted, userId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBlog(BlogsDto dto) {
		Blogs blog = (Blogs) Blogs.convertToDao(dto, Blogs.class);
		blog.setId(UUID.randomUUID().toString());
		blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
		blog.setModifyTime(new Timestamp(System.currentTimeMillis()));
		blogsMapper.insertBlog(blog);
		List<ClassifyBlogs> classifyBlogs=new ArrayList<>();
		classifyBlogs.add(new ClassifyBlogs(dto.getClassifyId(),dto.getId()));
		classifyMapper.insertClassifyBlogs(classifyBlogs);
	}

	@Override
	public void updateBlog(BlogsDto dto) {
		Blogs blog = (Blogs) Blogs.convertToDao(dto, Blogs.class);
		blog.setModifyTime(new Timestamp(System.currentTimeMillis()));
		blogsMapper.updateBlog(blog);
	}
}
