package org.jsp.usersbapp.restcontroller;

import java.util.List;

import org.jsp.usersbapp.dto.User;
import org.jsp.usersbapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User u = service.saveUser(user);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUser(@PathVariable(name = "id") Integer id) {
		User user = service.findUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/user")
	public List<User> findAllUser() {
		return service.findAllUser();

	}

	@PutMapping("/user")
	public String updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(Integer id) {
		return service.deleteUser(id);
	}

	@GetMapping("/user/find-by-name/{name}")
	public List<User> findUserByName(@PathVariable(name = "name") String name) {
		return service.findUserByName(name);
	}

	@GetMapping("/user/find-by-phone/{phone}")
	public User findUserByPhone(@PathVariable(name = "phone") Long phone) {
		return service.findUserByPhone(phone);
	}

	@GetMapping("/user/verify-by-phone")
	public User findUserByPhoneAndPassword(@RequestParam(name = "phone") Long phone,
			@RequestParam(name = "password") String password) {
		return service.findUserByPhoneAndPassword(phone, password);

	}

	@GetMapping("/user/verify-by-email")
	public User findUserByEmailAndPassword(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		return service.findUserByEmailAndPassword(email, password);
	}

}
