package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.MerchantDao;
import org.jsp.entity.Merchant;
import org.jsp.exception.MerchantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;
	
	public Merchant saveMerchant(Merchant merchant) {
		return merchantDao.saveMerchant(merchant);
	}
	public Merchant findMerchant(Integer id) {
		Optional<Merchant> findById = merchantDao.findMerchant(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}else {
//			return null;
			throw new MerchantNotFoundException("Invalid Merchant");
		}
	}
	public List<Merchant> findAllMerchant() {
		return merchantDao.findAll();
	}
	public String updateMerchant(Merchant merchant) {
		Optional<Merchant> findById = merchantDao.findMerchant(merchant.getId());
		if(findById.isPresent()) {
			Merchant dbmerchant = findById.get();
			dbmerchant.setAge(merchant.getAge());
			dbmerchant.setEmail(merchant.getEmail());
			dbmerchant.setGender(merchant.getGender());
			dbmerchant.setName(merchant.getName());
			dbmerchant.setPassword(merchant.getPassword());
			dbmerchant.setPhone(merchant.getPhone());
			
			merchantDao.saveMerchant(dbmerchant);
			return "successfully updated";
		}else {
			return "Invalid Merchant id";
		}
	}
	public String deleteMerchant(Integer id) {
		Optional<Merchant> findById = merchantDao.findMerchant(id);
		if(findById.isPresent()) {
			merchantDao.deleteMerchant(id);
			return "merchant deleted";
		}else {
			return "Invalid Merchant id";
		}
	}
	
}
