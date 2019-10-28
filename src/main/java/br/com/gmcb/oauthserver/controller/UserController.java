package br.com.gmcb.oauthserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gmcb.oauthserver.dto.UserDTO;
import br.com.gmcb.oauthserver.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	UserService userService;
	
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addUser(@RequestBody UserDTO userDTO) {
		userService.addUser(userDTO.getEmail(), userDTO.getPassword());
	}
}
