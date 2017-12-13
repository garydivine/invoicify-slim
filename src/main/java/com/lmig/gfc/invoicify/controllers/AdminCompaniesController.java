package com.lmig.gfc.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/admin/companies")
public class AdminCompaniesController {
	
	private CompanyRepository companyRepo;
	
	public AdminCompaniesController(CompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}
	
	@GetMapping("")
	public ModelAndView showDefault() {
		ModelAndView mv = new ModelAndView("admin/companies/default");
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView createCompany(Company company) {
		ModelAndView mv = new ModelAndView("redirect:/admin/companies");
		
		// Save the company
		companyRepo.save(company);
		
		return mv;
	}
	
}
