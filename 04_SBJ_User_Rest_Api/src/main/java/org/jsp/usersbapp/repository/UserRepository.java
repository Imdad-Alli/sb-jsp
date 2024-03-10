package org.jsp.usersbapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.usersbapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByName(String name);

	public Optional<User> findByPhone(Long phone);
	
	public Optional<User> findByPhoneAndPassword(Long phone, String password);
	
	public Optional<User> findByEmailAndPassword(String email, String password);
	
	
}
