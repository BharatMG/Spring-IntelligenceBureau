package com.xworkz.intelligenceBureau.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.entity.IntelligenceBureauEntity;
import com.xworkz.intelligenceBureau.repository.IntelligenceBureauRepository;

@Service
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

	@Override
	public List<IntelligenceBureauDTO> readAll() {
	List<IntelligenceBureauEntity> entity	=repository.readAll();

	List<IntelligenceBureauDTO> list=new ArrayList<IntelligenceBureauDTO>();
	
/*	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		IntelligenceBureauDTO intelligenceBureauDTO = (IntelligenceBureauDTO) iterator.next();*/
	for (IntelligenceBureauEntity intelligenceBureauDTO2 : entity) {
		IntelligenceBureauDTO dto =new IntelligenceBureauDTO();
		BeanUtils.copyProperties(intelligenceBureauDTO2,dto);
		
		list.add(dto);
	}
	System.out.println(list);
		return list;
	}
}