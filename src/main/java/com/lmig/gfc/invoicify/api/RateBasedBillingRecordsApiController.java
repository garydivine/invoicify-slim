package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/ratefees")
public class RateBasedBillingRecordsApiController {

	
	private CompanyRepository companyRepo;
	private BillingRecordRepository billingRecordRepo;
	
	public RateBasedBillingRecordsApiController(CompanyRepository companyRepo, BillingRecordRepository billingRecordRepo) {
		this.companyRepo = companyRepo;
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@PostMapping("")
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		record.setClient(companyRepo.findOne(record.getClient().getId()));
		return billingRecordRepo.save(record);
	}
	
	
}
