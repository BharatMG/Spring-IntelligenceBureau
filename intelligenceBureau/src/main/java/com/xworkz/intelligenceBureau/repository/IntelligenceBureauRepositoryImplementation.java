package com.xworkz.intelligenceBureau.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.catalina.Manager;
import org.springframework.beans.BeanUtils;
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
		// System.out.println(dto);
		IntelligenceBureauEntity entity = new IntelligenceBureauEntity();
		BeanUtils.copyProperties(dto, entity);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		System.out.println(entity);
		transaction.commit();
		manager.close();

		return true;
	}

	/*
	 * entity.setOfficerName(dto.getOfficerName());
	 * entity.setDesignation(dto.getDesignation());
	 * entity.setGender(dto.getGender()); entity.setEmail(dto.getEmail());
	 * entity.setMobileNumber(dto.getMobileNumber());
	 * entity.setIsMarried(dto.getIsMarried());
	 * entity.setPermanentAddress(dto.getPermanentAddress());
	 * entity.setWorkingAddress(dto.getWorkingAddress());
	 * entity.setBasicPayScale(dto.getBasicPayScale());
	 */

	@Override
	public List<IntelligenceBureauEntity> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readAll");
		List<IntelligenceBureauEntity> list = query.getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public IntelligenceBureauEntity findById(int id) {
		System.out.println("findById");
		EntityManager manager = factory.createEntityManager();
		IntelligenceBureauEntity entity = manager.find(IntelligenceBureauEntity.class, id);
		return entity;
	}

	@Override
	public List<IntelligenceBureauEntity> findByName(String officerName) {

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("findByName");

		query.setParameter("name", officerName);

		List<IntelligenceBureauEntity> ent = query.getResultList();
		System.out.println("findByName in Repository" + ent);
		return ent;
	}

	@Override
	public List<IntelligenceBureauEntity> findByEmail(String email) {
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("findByEmail");
		query.setParameter("email", email);
		List<IntelligenceBureauEntity> entity = query.getResultList();
		System.out.println("findByEmail in Repository " + entity);
		return entity;
	}

	@Override
	public List<IntelligenceBureauEntity> findByMobileNumber(Long mobileNumber) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByMobileNumber");
		query.setParameter("number", mobileNumber);
		List<IntelligenceBureauEntity> entity = query.getResultList();
		System.out.println("findByMobileNumber in repository" + entity);
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		EntityManager manager = factory.createEntityManager();
		IntelligenceBureauEntity entity = manager.find(IntelligenceBureauEntity.class, id);
		if (entity != null) {
			System.out.println(entity);
			manager.getTransaction().begin();

			manager.remove(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByEmail(String email) {
		System.out.println("deleteByEmail repository method");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query q = manager.createNamedQuery("deleteByEmail");
		q.setParameter("e", email);
		int row = q.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		return row > 0;

	}

	@Override
	public boolean deleteByName(String officerName) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("deleteByName repository method started");
		manager.getTransaction().begin();
		Query query2 = manager.createNamedQuery("deleteByName");
		query2.setParameter("n", officerName);
		int row = query2.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		return row > 0;
	}

	@Override
	public boolean deleteByMobileNumber(Long mobileNumber) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("deleteByMobileNumber repository method");
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("deleteByMobileNumber");
		query.setParameter("mobile", mobileNumber);
		int row = query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		if (row > 0) {
			return true;
		} else {
			System.out.println("no such data present");
			return false;
		}
	}

	@Override
	public boolean updateById(IntelligenceBureauDTO dto) {
		EntityManager manager = factory.createEntityManager();
		IntelligenceBureauEntity entity=new IntelligenceBureauEntity();
		manager.getTransaction().begin();
		BeanUtils.copyProperties(dto, entity);
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}
}
