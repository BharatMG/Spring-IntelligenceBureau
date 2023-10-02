package com.xworkz.intelligenceBureau.repository;

import org.springframework.stereotype.Component;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
@Component
public class IntelligenceBureauRepositoryImplementation implements IntelligenceBureauRepository {

	public IntelligenceBureauRepositoryImplementation() {
		System.out.println("IntelligenceBureauRepositoryImplementation constructor");
	}

	@Override
	public boolean onSave(IntelligenceBureauDTO dto) {
		System.out.println("repository onsave method invoked");
		System.out.println(dto);
		return true;
	}
} 