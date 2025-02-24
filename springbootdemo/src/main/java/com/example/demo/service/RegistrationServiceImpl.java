package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository reg_repo;
	
	public RegistrationServiceImpl(@Autowired RegistrationRepository reg_repo) {
		super();
		this.reg_repo = reg_repo;
	}

	@Override
	public Registration save(Registration reg) {
		// TODO Auto-generated method stub
		return reg_repo.save(reg);
	}

	@Override
	public Registration getReg(int reg_id) {
		// TODO Auto-generated method stub
		Optional<Registration> op=reg_repo.findById(reg_id);
		if(op!=null && op.isPresent())
		{
			return op.get();
		}
		return null;
	}

}
