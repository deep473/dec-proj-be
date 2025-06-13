package salesSavvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import salesSavvy.dto.LoginData;
import salesSavvy.entity.Users;
import salesSavvy.service.UsersService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
public class UsersController {
	@Autowired
	UsersService service;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody Users user) {
		System.out.println(user);
		return service.addUser(user);
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody LoginData data) {	
		return service.validate(data);
	}
	
}
