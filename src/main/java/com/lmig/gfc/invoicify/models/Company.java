package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// This needs to be an entity
@Entity
public class Company {

	// This needs an id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// This needs a name
	private String name;
	
	// This needs a list of invoice objects named invoices as one-to-many relationship mapped by "company"
	@ManyToMany(mappedBy = "company")
	@JsonIgnore
	private List<Invoice> invoices;
	
	public Company() {}
	
	public Company(String name) {
		this.name = name;
	}
	
	
	
	// Lots of getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
}
