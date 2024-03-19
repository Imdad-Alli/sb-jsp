package org.jsp.restcontroller;

import java.util.List;

import org.jsp.entity.Merchant;
import org.jsp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class MerchantRestController {
	@Autowired
	private MerchantService merchantService;

	@PostMapping("/merchant")
	public ResponseEntity<Merchant> saveMerchant(@RequestBody Merchant merchant) {
		return new ResponseEntity<>(merchantService.saveMerchant(merchant), HttpStatus.CREATED);
	}

	@GetMapping("/merchant/{id}")
	public ResponseEntity<Merchant> findMerchant(@PathVariable Integer id) {
		return new ResponseEntity<>(merchantService.findMerchantById(id), HttpStatus.OK);
	}

	@PutMapping("/merchant")
	public ResponseEntity<String> updateMerchant(@RequestBody Merchant merchant) {
		return new ResponseEntity<>(merchantService.updateMerchant(merchant), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/merchant/{id}")
	public ResponseEntity<String> deleteMerchant(@PathVariable Integer id) {
		return new ResponseEntity<>(merchantService.deleteMerchant(id), HttpStatus.OK);
	}
	
	@GetMapping("/merchants")
	public List<Merchant> findAllMerchants(){
		return merchantService.findAllMerchant();
	}

	@GetMapping("/merchant/find-by-name/{name}")
	public List<Merchant> findMerchantsByName(@PathVariable String name) {
		return merchantService.findMerchantsByName(name);
	}

	@GetMapping("/merchant/find-by-phone/{phone}")
	public Merchant findMerchantByPhone(@PathVariable Long phone) {
		return merchantService.findMerchantByPhone(phone);
	}

	@PostMapping("/merchant/verify-by-phone-password")
	public Merchant verifyUserByPhoneAndPassword(@RequestParam(name = "phone") Long phone,
			@RequestParam(name = "password") String password) {
		return merchantService.findMerchantByPhoneAndPassword(phone, password);
	}

}
