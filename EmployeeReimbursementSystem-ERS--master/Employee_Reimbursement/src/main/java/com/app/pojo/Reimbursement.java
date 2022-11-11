package com.app.pojo;

import java.util.Date; 

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.app.entity.Hospital;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reimbursement {
	
	@ApiModelProperty(value="id to identify reimbursement uniqely")
	@NotNull(message="rid is mandatory")
	private int reimbursementId;
	@ApiModelProperty(value="id to identify user uniqely")
	private int userId;
	@ApiModelProperty(value=" to identify reason ")
	private String reason;
	@ApiModelProperty(value="to  identify what is amount")
	private int amount;
	@ApiModelProperty(value="to identify status")
	private String status;
	@ApiModelProperty(value="on which date reimbursement raised")
	private Date raisedOn;
	@ApiModelProperty(value="to identify userName uniqely")
	private String userName;
	
}