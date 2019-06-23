package koboldblogprovider.koboldblogprovider.dao;

import dto.UserDto;

import java.sql.Timestamp;
import java.util.UUID;

public class User {
	private String id;
	private String username;
	private Timestamp birthday;
	private String description;
	private Boolean sex;
	private String password;

	public String getId() {
		return id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	private Timestamp creationTime;

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public UserDto convertToDto(){
		UserDto dto=new UserDto();
		dto.setBirthday(this.getBirthday());
		dto.setUsername(this.getUsername());
		dto.setCreationTime(this.getCreationTime());
		dto.setDescription(this.getDescription());
		dto.setId(this.getId());
		dto.setSex(this.getSex());
		dto.setPassword(this.getPassword());
		return dto;
	}

	public static User convertToDao(UserDto dto){
		User dao=new User();
		dao.setBirthday(dto.getBirthday());
		dao.setUsername(dto.getUsername());
		dao.setCreationTime(dto.getCreationTime());
		dao.setDescription(dto.getDescription());
		dao.setId(dto.getId());
		dao.setSex(dto.getSex());
		dao.setPassword(dto.getPassword());
		return dao;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(String id) {
		this.id = id;
	}
}
