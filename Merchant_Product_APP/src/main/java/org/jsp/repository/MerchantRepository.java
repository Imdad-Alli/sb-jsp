package org.jsp.repository;

import java.util.List;

import org.jsp.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
	public List<Merchant> findByName(String name);

	public Merchant findByPhone(Long phone);

	public Merchant findByPhoneAndPassword(Long phone, String password);
}