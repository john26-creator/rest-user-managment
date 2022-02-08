package com.user.management.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.usermanagement.model.User;
import com.user.management.usermanagement.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@PostMapping("/user/register")
	public String registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			return getErrorMessages (errors);
		} else {
			userService.save(user);
			return "user inserted";
		}

	}
	
	public String getErrorMessages (List<ObjectError> errors) {
		StringBuilder builder = new StringBuilder( "" );
		for (ObjectError error : errors) {
			builder.append(error.getDefaultMessage());
			builder.append("\n");
		}
		return builder.toString();
	}

}
