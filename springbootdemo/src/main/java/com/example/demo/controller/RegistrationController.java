package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService reg_service;

	public RegistrationController(@Autowired RegistrationService reg_service) {
		super();
		this.reg_service = reg_service;
	}
	
	@PostMapping("/reg")
	public Registration newRegistration(@RequestBody Registration reg)
	{
		return reg_service.save(reg);
	}
	
	@GetMapping("/reg/{reg_id}")
	public Registration getreg(@PathVariable int reg_id)
	{
		return reg_service.getReg(reg_id);
	}
}
