package koboldblogweb.koboldblogweb.viewmodel.request.blogs;

import dto.dtos.BlogStatus;
import koboldblogweb.koboldblogweb.viewmodel.request.PagerInfoModel;

public class BlogsByStatus extends PagerInfoModel {
    private BlogStatus blogStatus;

    public BlogStatus getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(BlogStatus blogStatus) {
        this.blogStatus = blogStatus;
    }
}
