package com.app.controller;

import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Reimbursement;
import com.app.pojo.Response;
import com.app.service.IReimbursementSrv;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/reimbursement")
@Api(value=" reimbursementcontroller" , description = "rest api work on reimbursement entity")
public class ReimbursementController {

	Logger log = LoggerFactory.getLogger(ReimbursementController.class);
	
	@Autowired
	private IReimbursementSrv rmtSrv;
	public void setRmtSrv(IReimbursementSrv rmtSrv) {
		this.rmtSrv = rmtSrv;
	}
	
	@PostMapping(value="/apply")
	 @ApiOperation(value =" api to apply a reimbursement in application")
	public Response applyForReimbursement(@RequestBody @Valid Reimbursement rObj){
		log.debug("apply reimbursement - post rest api invoked with input -{} " , rObj);
		String responseData = rmtSrv.applyReimbursement(rObj);
		log.debug("output from apply reimbursement -  post rest api is { }" , response);
		Response response = new Response(200, responseData);
		return response;
		
	}
	  @ApiOperation(value="get specific  reimbursement data from an application ")
	@GetMapping(value="/all/{userId}")
	public Response getAllReimbursements(@PathVariable int userId){
		  log.debug("get reimbursement- get rest api -{ }" ,userId);
		List<Reimbursement> reimbursements = rmtSrv.getReimbursements(userId);
		log.debug("output from get reimbursement - get rest api -{ } " , response);
		Response response = new Response(200, reimbursements);
		return response;
	}
	
	// view all reimbursements
	  @ApiOperation(value="api to get all reimbursements from application")
	@GetMapping(value="/all")
	public Response getAllReimbursements() {
		  log.debug(" get all reimbursements - get rest api ");
		List<Reimbursement> reimbursements = rmtSrv.getAllReimbursements();
		log.debug("output from get all reimbursements - get rest api - { } " , response);
		Response response = new Response(200, reimbursements);
		return response;
	}
	
	// resolve reimbursement -- update the status of reimbursement
	  @ApiOperation(value = " api to update existing  reimbursement in application")
	@PutMapping(value="/resolve")
	public Response resolveReimbursement(@RequestBody Reimbursement rObj) {
			 log.debug("resolve reimbursement = put rest api invokes with input - { } " ,rObj);
		  String result = rmtSrv.updateReimbursements(rObj);
		  log.debug(" output from resolve reimbursement - put rest api is { } - ",response);
		  Response response = new Response(200, result);
		  return response;
	}
	
}
