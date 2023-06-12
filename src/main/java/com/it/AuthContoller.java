package com.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.controller.AppResponse;
import com.it.controller.UserDTO;
import com.it.service.LoginService;


@RestController
@RequestMapping("/v4")
@CrossOrigin("*")
public class AuthContoller {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/auth")
	public AppResponse authUser(@RequestBody UserDTO userDTO) {
		AppResponse appResponse=new AppResponse();
		loginService.findByUsername(userDTO.getUsername(), userDTO.getPassword());
		appResponse.setCode("200");
		appResponse.setMessage("Hey username and password are correct!");			
		return appResponse;
	}
	
	@PostMapping("/cauth")
	public AppResponse cauthUser(@RequestBody UserDTO userDTO) {
		AppResponse appResponse=new AppResponse();
		loginService.save(userDTO);
		appResponse.setCode("200");
		appResponse.setMessage("Login is created");			
		return appResponse;
	}

}
