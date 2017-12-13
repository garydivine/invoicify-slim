package com.lmig.gfc.invoicify.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
	
	List<BillingRecord> findByClientAndLineItemIsNull(Company client);

}
