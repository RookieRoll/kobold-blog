package dto.dtos;

import java.sql.Timestamp;

public class BlogsListDto extends  BaseDto {
    private String id;
    private String title;
    private String subContent;
    private Timestamp modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSubContent() {
        return subContent;
    }

    public void setSubContent(String subcontent) {
        this.subContent = subcontent;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
