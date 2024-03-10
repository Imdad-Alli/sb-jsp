package org.jsp.usersbapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.usersbapp.dao.UserDao;
import org.jsp.usersbapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public User findUser(Integer id) {
		Optional<User> optional = userDao.findUserById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<User> findAllUser() {
		List<User> users = userDao.findAll();

		return users;
	}

	public String updateUser(User user) {
		Optional<User> optional = userDao.findUserById(user.getId());
		if (optional.isPresent()) {
			User dbUser = optional.get();
			dbUser.setName(user.getName());
			dbUser.setGender(user.getGender());
			dbUser.setPhone(user.getPhone());
			dbUser.setEmail(user.getEmail());
			dbUser.setPassword(user.getPassword());

			return "User record updated";
		} else {
			return "Invalid Id";
		}
	}

	public String deleteUser(Integer id) {
		Optional<User> optional = userDao.findUserById(id);
		if (optional.isPresent()) {
			userDao.deleteUser(id);
			return "user record deleted";
		} else {
			return "Invalid id";
		}
	}

	public List<User> findUserByName(String name) {
		List<User> users = userDao.findUserByName(name);

		return users;
	}

	public User findUserByPhone(Long phone) {
		Optional<User> optional = userDao.findUserByPhone(phone);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User findUserByPhoneAndPassword(Long phone, String password) {
		Optional<User> optional = userDao.findUserByPhoneAndPassword(phone, password);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User findUserByEmailAndPassword(String email, String password) {
		Optional<User> optional = userDao.findUserByEmailAndPassword(email, password);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

}
