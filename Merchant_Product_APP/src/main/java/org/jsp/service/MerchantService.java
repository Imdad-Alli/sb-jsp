package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.MerchantDao;
import org.jsp.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantDao.saveMerchant(merchant);
	}

	public Merchant findMerchantById(Integer id) {
		Optional<Merchant> findById = merchantDao.findMerchantById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}
	}

	public String updateMerchant(Merchant merchant) {
		Optional<Merchant> findById = merchantDao.findMerchantById(merchant.getId());
		if (findById.isPresent()) {
			Merchant dbMerchant = findById.get();
			dbMerchant.setName(merchant.getName());
			dbMerchant.setAge(merchant.getAge());
			dbMerchant.setGender(merchant.getGender());
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());

			merchantDao.saveMerchant(dbMerchant);
			return "merchant updated";
		} else {
			return "Invalid merchant id";
		}
	}

	public String deleteMerchant(Integer id) {
		Optional<Merchant> findById = merchantDao.findMerchantById(id);

		if (findById.isPresent()) {
			merchantDao.deleteMerchant(id);
			return "merchant deleted";
		} else {
			return "Invalid merchant";
		}
	}

	public List<Merchant> findMerchantsByName(String name) {
		return merchantDao.findMerchantByName(name);
	}

	public List<Merchant> findAllMerchant() {
		return merchantDao.findAllMerchant();
	}

	public Merchant findMerchantByPhone(Long phone) {
		return merchantDao.findMerchantByPhone(phone);
	}

	public Merchant findMerchantByPhoneAndPassword(Long phone, String password) {
		return merchantDao.findMerchantByPhoneAndPassword(phone, password);
	}
}
