package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Response;
import com.app.pojo.User;
import com.app.service.IUserSrv;

import io.swagger.annotations.ApiOperation;

@RestController  // @Controller + @ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/user")
@Api(value=" usercontroller" , description = "rest api work on user entity")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserSrv userSrv;
	public void setUserSrv(IUserSrv userSrv) {
		this.userSrv = userSrv;
	}
	
	@PostMapping(value="/new")
	@ApiOperation(value =" api to apply a new user in application")
	public Response createNewUser(@RequestBody @Valid User user){
		log.debug("new user - post rest api invoked with input -{} " , user);
		String responseData = userSrv.createUser(user);
		log.debug("output from new user -  post rest api is { }" , resp);
		Response resp = new Response(200, responseData);
		return resp;
	}
	
	@PutMapping(value="/update")
	 @ApiOperation(value = " api to update existing  user data  in application")
	public Response updateUser(@RequestBody User user){
		 log.debug("update user = put rest api invokes with input - { } " ,user);
		String responseData = userSrv.updateUser(user);
		log.debug(" output from update user - put rest api is { } -", resp);
		Response resp = new Response(200, responseData);
		return resp;
	}
	
	@DeleteMapping(value="/delete/{userId}")
	@ApiOperation(value=" api to delete a user in application")
	public Response deleteUser(@PathVariable int userId) {
		 log.debug("delete user- deletet rest api - { }" , userId);
		String responseData = userSrv.deleteUser(userId);
		log.debug("output from delete user-deletet rest api -{ }" , resp);
		Response resp = new Response(200, responseData);
		return resp;
		
	}
	
	@GetMapping(value="/validate")
	@ApiOperation(value="get specific  user data from an application ")
	public Response getUser(@RequestBody User user){
		log.debug("get user- get rest api -{ }" ,user);
		User userObj = userSrv.getUser(user.getUserName(), user.getPwd());
		log.debug("output from get user - get rest api -{ } " , resp);
		Response resp = new Response(200, userObj);
		return resp;
	}
	

}
