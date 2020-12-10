----------------------------------------------------------------------------------------------------------------------------------
//Task 1
//1) Create connection between JAVA & mysql.
-----------------------------------------------------------------------------------------------------------------------------------
//File:- FirstAccTask.java
//Code:-

import java.sql.*;  
class FirstAccTask
{  
public static void main(String []a){  
try
{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb","root","student");  
System.out.println("connected with database named mydb");  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
} 

 

-----------------------------------------------------------------------------------------------------------------------------
//Task 2
//1) Create Signup page REST API (create one POST & one Get call api) using Spring boot MVC REST application
------------------------------------------------------------------------------------------------------------------------------
//File-User.java
//Code:-

package com.journaldev.spring.model;

import java.io.Serializable;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class User implements Serializable{

	
	private String name;
        private String contact;
        private String gender;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String g) {
		this.gender = g;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String c) {
		this.contact = c;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String p) {
		name = p;
	
	
}

-----------------------------------------------------------------------------------------------------------------------------

//File:- UserController.java
//Code:-

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

--------------------------------------------------------------------------------------------------------------------------------------


//File:- UserRestURIConst.java
//Code:-

package com.journaldev.spring.controller;

public class UserRestURIConst {

public static final String DUMMY_USER = "/rest/user/dummy";
	public static final String GET_ALL_USER = "/rest/users";
	public static final String CREATE_USER = "/rest/user/create";
	
}


