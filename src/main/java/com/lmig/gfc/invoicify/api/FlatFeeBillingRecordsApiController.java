package com.lmig.gfc.invoicify.api;

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/flatfees")
public class FlatFeeBillingRecordsApiController {
	
	private CompanyRepository companyRepo;
	private BillingRecordRepository billingRecordRepo;
	
	public FlatFeeBillingRecordsApiController(CompanyRepository companyRepo, BillingRecordRepository billingRecordRepo) {
		this.companyRepo = companyRepo;
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@PostMapping("")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		record.setClient(companyRepo.findOne(record.getClient().getId()));
		return billingRecordRepo.save(record);
	}

}
