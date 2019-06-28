package koboldblogweb.koboldblogweb.viewmodel.request;

import dto.ClassifyDto;
import utils.BeanMapperUtils;

import javax.validation.constraints.NotBlank;

public class ClassifyModifyRequest {
	@NotBlank(message = "名称不能为空")
	private String classifyName;
	private int sort;



	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public ClassifyDto convertToDto(String userId){
		ClassifyDto dto= BeanMapperUtils.mapper(this,ClassifyDto.class);
		dto.setUserId(userId);
		dto.setDeleted(false);
		dto.setStopped(false);
		return dto;
	}
}
