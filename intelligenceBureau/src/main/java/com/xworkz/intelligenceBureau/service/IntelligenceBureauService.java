package com.xworkz.intelligenceBureau.service;

import java.util.List;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;

public interface IntelligenceBureauService {
	
	public boolean onSave(IntelligenceBureauDTO dto);
	public List<IntelligenceBureauDTO> readAll();

}
