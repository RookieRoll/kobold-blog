package koboldblogprovider.koboldblogprovider.mapper;

import koboldblogprovider.koboldblogprovider.dao.Blogs;

import java.util.List;

public interface BlogsApiMapper {
    List<Blogs> getBlogs();

    List<Blogs> getBlogsByClassify(String classifyId);

    Blogs getBlog(String id);
}
