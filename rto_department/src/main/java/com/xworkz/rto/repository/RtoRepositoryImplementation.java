package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.entity.RtoEntity;

@Repository
public class RtoRepositoryImplementation implements RtoRepository {

	@Autowired
	EntityManagerFactory factory;

	public RtoRepositoryImplementation() {
		System.out.println("RtoRepositoryImplementation constructor");
	}

	@Override
	public RtoEntity login(String emailId, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("login");
		query.setParameter("email", emailId);
		query.setParameter("password", password);
		return (RtoEntity) query.getSingleResult();
	}

	@Override
	public boolean onSave(RtoDTO dto) {
		System.out.println("onsave method in repository");
		EntityManager manager = factory.createEntityManager();
		System.out.println(dto);
		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setRegistereDateTime(LocalDateTime.now());
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public List<RtoEntity> readAll() {
		System.out.println("readAll method in repository");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readAll");
		return (List<RtoEntity>) query.getResultList();
	}

	@Override
	public RtoEntity adminLogin(String emailId, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("login");
		query.setParameter("email", emailId);
		query.setParameter("password", password);
		try {
			return (RtoEntity) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RtoEntity> searchByState(String state) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByState");
		query.setParameter("state", state);
		List<RtoEntity> entities = query.getResultList();
		return entities;
	}

	
}
