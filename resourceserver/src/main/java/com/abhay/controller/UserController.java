package com.abhay.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhay.entity.UserData;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/user")
	public UserData findUser(@RequestParam int id) {
		return new UserData(id, "abhay", "sah");

	}

	@GetMapping("/otheruser")
	// @PreAuthorize("#oauth2.hasScope('writeIngredients')")
	public UserData getUser(@RequestParam int id) {
		return new UserData(id, "uday", "sah");
	}

	@GetMapping("/resouceOwnerInfo")
	public String getData(Authentication auth) {

		String name = auth.getName();
		String roles = auth.getAuthorities().toString();
		return name + "  roles" + roles;
				
		

	}

}
