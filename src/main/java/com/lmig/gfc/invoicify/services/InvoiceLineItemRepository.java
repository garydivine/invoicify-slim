package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.InvoiceLineItem;

public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem, Long> {

}
