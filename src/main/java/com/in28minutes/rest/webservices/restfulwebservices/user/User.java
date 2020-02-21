package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the user.")
@Entity
public class User {

	@Id

	private Integer id;

	@Size(min = 2, message = "Name should have at least 2 characters.")
	@ApiModelProperty(notes = "Name should have at least 2 characters.")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth date should be in the past.")
	private Date brithDate;
	
	public User(Integer id, String name, Date brithDate) {
		super();
		this.id = id;
		this.name = name;
		this.brithDate = brithDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", brithDate=" + brithDate + "]";
	}
	
}
