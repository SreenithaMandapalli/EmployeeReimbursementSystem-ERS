package com.app.pojo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	
	@ApiModelProperty(value="id to identify user uniqely")
	@NotNull(message="id is mandatory")
	private int uId;
	@ApiModelProperty(value="userName to identify user ")
	private String userName;
	@ApiModelProperty(value="user pwd")
	private String pwd;
	@ApiModelProperty(value=" to identity user fName")
	private String fName;
	@ApiModelProperty(value="to identify user lName")
	private String lName;
	@ApiModelProperty(value="to identify user role uniqely")
	private String role;
	@ApiModelProperty(value="emailId ")
	private String emailId;
	
}