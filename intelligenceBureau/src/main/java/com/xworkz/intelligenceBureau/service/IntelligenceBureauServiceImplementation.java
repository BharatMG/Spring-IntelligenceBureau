package com.xworkz.intelligenceBureau.service;

import java.util.ArrayList;

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
		if (dto != null && dto.getEmail() != null && dto.getGender() != null) {
			boolean save = repository.onSave(dto);
			System.out.println(save);
		}
		return true;
	}

	@Override
	public List<IntelligenceBureauDTO> readAll() {
		List<IntelligenceBureauEntity> entity = repository.readAll();

		List<IntelligenceBureauDTO> list = new ArrayList<IntelligenceBureauDTO>();

		for (IntelligenceBureauEntity intelligenceBureauDTO2 : entity) {
			IntelligenceBureauDTO dto = new IntelligenceBureauDTO();
			BeanUtils.copyProperties(intelligenceBureauDTO2, dto);

			list.add(dto);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public IntelligenceBureauDTO findById(int id) {
		System.out.println("findById in service:-" + id);
		IntelligenceBureauDTO dto = new IntelligenceBureauDTO();
		if (id != 0) {
			IntelligenceBureauEntity entity = repository.findById(id);
			if (entity != null) {
				System.out.println("entity is not null");
				BeanUtils.copyProperties(entity, dto);
			}
		} else {
			System.out.println("entity is null");

		}

		return dto;
	}

	@Override
	public List<IntelligenceBureauDTO> findByName(String officerName) {
		System.out.println("findByName in service: " + officerName);

		List<IntelligenceBureauEntity> entity = repository.findByName(officerName);

		List<IntelligenceBureauDTO> dtos = new ArrayList<IntelligenceBureauDTO>();

		for (IntelligenceBureauEntity intelligenceBureauEntity : entity) {
			System.out.println(intelligenceBureauEntity);

			IntelligenceBureauDTO dto = new IntelligenceBureauDTO();

			BeanUtils.copyProperties(intelligenceBureauEntity, dto);
			dtos.add(dto);
		}
		System.out.println("entity is null");
		return dtos;
	}

	@Override
	public List<IntelligenceBureauDTO> findByEmail(String email) {
		System.out.println("findByEmail in service" + email);

		List<IntelligenceBureauEntity> entity = repository.findByEmail(email);
		List<IntelligenceBureauDTO> dtos = new ArrayList<IntelligenceBureauDTO>();
		
		for (IntelligenceBureauEntity intelligenceBureauEntity : entity) {
			System.out.println(intelligenceBureauEntity);
			IntelligenceBureauDTO dto = new IntelligenceBureauDTO();
			BeanUtils.copyProperties(intelligenceBureauEntity, dto);
			dtos.add(dto);
		}
		System.out.println("entity is null");
		return dtos;
	}
}