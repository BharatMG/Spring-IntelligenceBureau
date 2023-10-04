package com.xworkz.intelligenceBureau.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.entity.IntelligenceBureauEntity;

@Repository
public class IntelligenceBureauRepositoryImplementation implements IntelligenceBureauRepository {
	@Autowired
	EntityManagerFactory factory;

	public IntelligenceBureauRepositoryImplementation() {
		System.out.println("IntelligenceBureauRepositoryImplementation constructor");
	}

	@Override
	public boolean onSave(IntelligenceBureauDTO dto) {
		System.out.println("repository onsave method invoked");
		System.out.println(dto);

		IntelligenceBureauEntity entity = new IntelligenceBureauEntity();
		entity.setOfficerName(dto.getOfficerName());
		entity.setDesignation(dto.getDesignation());
		entity.setGender(dto.getGender());
		entity.setEmail(dto.getEmail());
		entity.setMobileNumber(dto.getMobileNumber());
//		entity.setMarried(Boolean.parseBoolean(dto.isMarried()));
		entity.setIsMarried(dto.getIsMarried());
		entity.setPermanentAddress(dto.getPermanentAddress());
		entity.setWorkingAddress(dto.getWorkingAddress());
		entity.setBasicPayScale(dto.getBasicPayScale());

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		System.out.println(entity);
		transaction.commit();
		manager.close();

		return true;
	}

	@Override
	public List<IntelligenceBureauEntity> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readAll");
		List<IntelligenceBureauEntity> list = query.getResultList();
		System.out.println(list);
		return list;
	}

}
