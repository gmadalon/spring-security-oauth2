package br.com.gmcb.oauthserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gmcb.oauthserver.dto.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(method = RequestMethod.POST)
	public void addUser(@RequestBody UserDTO userDTO) {
		
		
	}
}
