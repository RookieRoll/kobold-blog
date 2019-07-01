package koboldblogprovider.koboldblogprovider.dao;

import java.util.UUID;

public class ClassifyBlogs {

    private String id;

    public ClassifyBlogs(String classifyId, String blogId) {
       this(UUID.randomUUID().toString(),classifyId,blogId);
    }

    public ClassifyBlogs(String id, String classifyId, String blogId) {
        this.id = id;
        this.classifyId = classifyId;
        this.blogId = blogId;
    }

    private String classifyId;
    private String blogId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

}
