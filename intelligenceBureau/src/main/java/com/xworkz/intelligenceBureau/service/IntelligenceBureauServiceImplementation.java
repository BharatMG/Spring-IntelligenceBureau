package com.xworkz.intelligenceBureau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.repository.IntelligenceBureauRepository;

@Component
public class IntelligenceBureauServiceImplementation implements IntelligenceBureauService {

	public IntelligenceBureauServiceImplementation() {
		System.out.println("IntelligenceBureauServiceImplementation constructor");
	}

	@Autowired
	IntelligenceBureauRepository repository;

	@Override
	public boolean onSave(IntelligenceBureauDTO dto) {
		System.out.println("service save method invoked");
		if (dto!=null && dto.getEmail()!=null && dto.getGender()!=null) {
		boolean save = repository.onSave(dto);
		System.out.println(save);
		}
		return true;
	}
}