package dto.dtos;

import java.sql.Timestamp;
import java.util.List;

public class BlogsDto extends BaseDto {
	private String id;
	private String title;
	private String content;
	private String subContent;
	private Timestamp createTime;
	private BlogStatus blogStatus;
	private Timestamp modifyTime;
	private boolean isDeleted;
	private String userId;

	private List<String> classifyId;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubContent() {
		return subContent;
	}

	public void setSubContent(String subcontent) {
		this.subContent = subcontent;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public BlogStatus getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(BlogStatus blogStatus) {
		this.blogStatus = blogStatus;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<String> getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(List<String> classifyId) {
		this.classifyId = classifyId;
	}
}
