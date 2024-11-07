package com.springboot.insurance_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {
	
	@PostMapping("/claim/process/{pid}/{phid}/{eid})
	public void processClaim() {
		public ResponseEntity<String> processClaim(@RequestBody ClaimRequest claimRequest) {
		    // Logic to process the claim
		    return ResponseEntity.ok("Claim processed successfully");
		}

	}
	
}