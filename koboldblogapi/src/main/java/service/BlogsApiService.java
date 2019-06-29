package service;

import dto.dtos.BlogsDto;

import java.util.List;

public interface BlogsApiService {
    List<BlogsDto> getBlogs();

    List<BlogsDto> getBlogsByClassify(String classifyId);

    BlogsDto getBlog(String id);
}
