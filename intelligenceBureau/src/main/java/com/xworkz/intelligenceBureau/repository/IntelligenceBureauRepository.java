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

	public List<IntelligenceBureauEntity> findByMobileNumber(Long mobileNumber);

	public boolean deleteById(int id);

	public boolean deleteByEmail(String email);

	public boolean deleteByName(String officerName);
	
	public abstract boolean deleteByMobileNumber(Long mobileNumber);
	
	public boolean updateById(IntelligenceBureauDTO dto);

}
