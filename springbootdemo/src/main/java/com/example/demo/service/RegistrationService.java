package com.example.demo.service;

import com.example.demo.model.Registration;

public interface RegistrationService {

	Registration save(Registration reg);
	
	Registration getReg(int reg_id);
}
