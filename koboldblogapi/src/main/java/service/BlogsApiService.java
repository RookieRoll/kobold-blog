package service;

import dto.dtos.BlogsDto;

import java.util.List;

public interface BlogsApiService {
    List<BlogsDto> getBlogs(int pageIndex,int pageSize);

    List<BlogsDto> getBlogsByClassify(String classifyId,int pageIndex,int pageSize);

    BlogsDto getBlog(String id);
}
