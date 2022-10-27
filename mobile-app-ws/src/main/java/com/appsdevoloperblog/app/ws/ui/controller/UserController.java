package com.appsdevoloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevoloperblog.app.ws.exceptions.UserserviceException;
import com.appsdevoloperblog.app.ws.ui.model.request.UserDetailsRequestmodel;
import com.appsdevoloperblog.app.ws.ui.model.request.UserUpdatemodel;
import com.appsdevoloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/api") // http:localhost:8080/users

//passing the qurystring with optional and default
public class UserController {

	Map<String, UserRest> users;

	@GetMapping()
	public String getUser(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "return get user was called page=" + page + "limit" + limit + "sort=" + sort;
	}

//single user id passed in rest
	@GetMapping(path = "/{userId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(true)throw new UserserviceException("user service exceprion");
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping()
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestmodel userdetails)

	{
		UserRest returnvalue = new UserRest();
		returnvalue.setEmail(userdetails.getEmail());
		returnvalue.setFirstname(userdetails.getFirstname());
		returnvalue.setLastname(userdetails.getLastname());
		returnvalue.setUserid(userdetails.getPassword());

		String userId = UUID.randomUUID().toString();
		returnvalue.setUserid(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnvalue);
		return new ResponseEntity<UserRest>(returnvalue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}")
	public UserRest updateUser(@Valid @RequestBody UserUpdatemodel userupdate,@PathVariable String userId) {
		UserRest StoredUser=users.get(userId);
		StoredUser.setFirstname(userupdate.getFirstname());
		StoredUser.setLastname(userupdate.getLastname());
		users.put(userId,StoredUser);
		return StoredUser;
	
	}

	@DeleteMapping(path = "/{Id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String Id) {
		users.remove(Id);
		return ResponseEntity.noContent().build();
	}

}
