package koboldblogweb.koboldblogweb.service;

import dto.dtos.BlogsDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import service.BlogsApiService;

import java.util.List;

@Service
public class BlogsApiServiceImpl implements BlogsApiService {
    @Reference
    private BlogsApiService blogsApiService;

    @Override
    public List<BlogsDto> getBlogs(int pageIndex, int pageSize) {
        return blogsApiService.getBlogs(pageIndex, pageSize);
    }

    @Override
    public List<BlogsDto> getBlogsByClassify(String classifyId, int pageIndex, int pageSize) {
        return blogsApiService.getBlogsByClassify(classifyId, pageIndex, pageSize);
    }

    @Override
    public BlogsDto getBlog(String id) {
        return blogsApiService.getBlog(id);
    }
}
