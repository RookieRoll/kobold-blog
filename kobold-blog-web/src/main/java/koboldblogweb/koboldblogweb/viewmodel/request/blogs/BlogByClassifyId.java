package koboldblogweb.koboldblogweb.viewmodel.request.blogs;

import koboldblogweb.koboldblogweb.viewmodel.request.PagerInfoModel;

public class BlogByClassifyId extends PagerInfoModel {
    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    private String classifyId;
}
