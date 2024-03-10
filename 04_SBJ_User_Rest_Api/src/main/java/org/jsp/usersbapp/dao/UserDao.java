package org.jsp.usersbapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.usersbapp.dto.User;
import org.jsp.usersbapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public List<User> findUserByName(String name) {
		return userRepository.findByName(name);
	}

	public Optional<User> findUserByPhone(Long phone) {
		return userRepository.findByPhone(phone);
	}
	
	public Optional<User> findUserByPhoneAndPassword(Long phone, String password) {
		return userRepository.findByPhoneAndPassword(phone, password);
	}
	
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	
}
