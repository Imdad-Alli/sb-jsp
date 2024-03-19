package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Merchant;
import org.jsp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantRepo;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepo.save(merchant);
	}

	public Optional<Merchant> findMerchantById(Integer id) {
		return merchantRepo.findById(id);
	}

	public void deleteMerchant(Integer id) {
		merchantRepo.deleteById(id);
	}

	public List<Merchant> findAllMerchant() {
		return merchantRepo.findAll();
	}

	public List<Merchant> findMerchantByName(String name) {
		return merchantRepo.findByName(name);
	}

	public Merchant findMerchantByPhone(Long phone) {
		return merchantRepo.findByPhone(phone);
	}

	public Merchant findMerchantByPhoneAndPassword(Long phone, String password) {
		return merchantRepo.findByPhoneAndPassword(phone, password);
	}
}
