package koboldblogweb.koboldblogweb.viewmodel.response;

import dto.dtos.BlogsDto;
import utils.BeanMapperUtils;

public class BlogsListResponse {
	private String id;
	private String title;
	private String subName;
	private String modifyTime;

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

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}


	public  static  BlogsListResponse convertToViewModel(BlogsDto dto)
	{
		return BeanMapperUtils.mapper(dto,BlogsListResponse.class);
	}
}
