package koboldblogweb.koboldblogweb.viewmodel.request.blogs;

import dto.dtos.BlogStatus;
import dto.dtos.BlogsDto;
import utils.BeanMapperUtils;

import java.util.List;

public class BlogCreateRequest {
    private static final int SUB_CONTENT_SIZE=200;
    private String title;
    private String content;
    private BlogStatus blogStatus;
    private List<String> classifyId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogStatus getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(BlogStatus blogStatus) {
        this.blogStatus = blogStatus;
    }


    public BlogsDto convertToDto(String userId){
        BlogsDto dto= BeanMapperUtils.mapper(this,BlogsDto.class);
        dto.setUserId(userId);
        dto.setDeleted(false);

        dto.setSubContent(this.getContent().length()>SUB_CONTENT_SIZE?this.getContent().substring(SUB_CONTENT_SIZE):this.getContent());
        return dto;
    }

    public List<String> getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(List<String> classifyId) {
        this.classifyId = classifyId;
    }
}
