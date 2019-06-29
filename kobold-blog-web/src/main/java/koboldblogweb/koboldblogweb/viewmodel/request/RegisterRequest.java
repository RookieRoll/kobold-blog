package koboldblogweb.koboldblogweb.viewmodel.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import dto.dtos.UserDto;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

public class RegisterRequest {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@NotBlank(message = "名称不能为空，并且名称唯一")
	private String username;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String description;
	private Boolean sex;
	@NotBlank(message = "密码不能为空")
	private String password;

	public UserDto convertToDto() {
		UserDto dto = new UserDto();
		dto.setSex(this.getSex());
		dto.setDescription(this.getDescription());
		dto.setCreationTime(new Timestamp(System.currentTimeMillis()));
		dto.setBirthday(new Timestamp(this.getBirthday().getTime()));
		dto.setUsername(this.getUsername());
		dto.setPassword(this.getPassword());
		return dto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
