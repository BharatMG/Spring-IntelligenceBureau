package com.xworkz.intelligenceBureau.repository;

import java.util.List;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.entity.IntelligenceBureauEntity;

public interface IntelligenceBureauRepository {
	
	public boolean onSave(IntelligenceBureauDTO dto);
	
	public List<IntelligenceBureauEntity> readAll();
	
	public IntelligenceBureauEntity findById(int id);
	
	public List<IntelligenceBureauEntity> findByName(String officerName);
	
	public List<IntelligenceBureauEntity> findByEmail(String email);

}
