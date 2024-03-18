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
	public Optional<Merchant> findMerchant(Integer id) {
		return merchantRepo.findById(id);
	}
	public List<Merchant> findAll(){
		return merchantRepo.findAll();
	}
	public Merchant updateMerchant(Merchant merchant) {
		return merchantRepo.save(null);
	}
	public void deleteMerchant(Integer id) {
		merchantRepo.deleteById(id);
	}
	
	
}
