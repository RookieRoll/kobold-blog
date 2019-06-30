package koboldblogprovider.koboldblogprovider.service;

import com.github.pagehelper.PageHelper;
import dto.dtos.BlogsDto;

import koboldblogprovider.koboldblogprovider.mapper.BlogsApiMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.BlogsApiService;

import java.util.List;
import java.util.stream.Collectors;

@Service(interfaceClass = BlogsApiService.class)
public class BlogsApiServiceImpl implements BlogsApiService {

    @Autowired
    private BlogsApiMapper blogsApiMapper;
    @Override
    public List<BlogsDto> getBlogs(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return blogsApiMapper.getBlogs().stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BlogsDto> getBlogsByClassify(String classifyid,int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return blogsApiMapper.getBlogsByClassify(classifyid).stream().map(m -> (BlogsDto) m.convertToDto(BlogsDto.class)).collect(Collectors.toList());
    }

    @Override
    public BlogsDto getBlog(String id) {
        return (BlogsDto)blogsApiMapper.getBlog(id).convertToDto(BlogsDto.class);
    }
}
