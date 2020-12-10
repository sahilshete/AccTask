package com.journaldev.spring.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.User;
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
		Map<Integer, User> userData = new HashMap<Integer, User>();
	
	@RequestMapping(value = UserRestURIConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody User getDummyUser() {
		logger.info("Start getDummyUser");
		User u = new User();
		
		u.setName("Sahil");
		u.setGender("MALE");
                u.setContact("9769656387");
                u.setpassword("abc")
 		userData.put(1, u);
		return u;
	}
	
	
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		logger.info("Start getAllusers.");
		List<User> users = new ArrayList<User>();
		Set<Integer> userKeys = userData.keySet();
		for(Integer i : userKeys){
			users.add(userData.get(i));
		}
		return users;
	}
	
	@RequestMapping(value = UserRestURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User u) {
		logger.info("Start createUser.");
		
		userData.put(1,u);
		return u;
	}
	
		
}
