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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantRestController {
	@Autowired
	private MerchantService merchantService;
	
	@PostMapping("/merchant")
	public Merchant saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}
	@GetMapping("/merchant/{id}")
	public Merchant findMerchant(@PathVariable(name = "id") Integer id) {
		return merchantService.findMerchant(id);
	}
	@GetMapping("/merchants")
	public List<Merchant> findAllMerchant() {
		return merchantService.findAllMerchant();
	}
	@PutMapping("/merchant")
	public ResponseEntity<String> updateMerchant(@RequestBody Merchant merchant) {
		return new ResponseEntity<>(merchantService.updateMerchant(merchant),HttpStatus.ACCEPTED); 
	}
	@DeleteMapping("/merchant/{id}")
	public String deleteMerchant(@PathVariable Integer id) {
		return merchantService.deleteMerchant(id);
	}
	
	
}
