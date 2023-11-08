package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.UserEntity;
@Repository
public class RtoUserRepositoryImplementation implements RtoUserRepository {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean userSave(UserDTO userDTO) {
		EntityManager manager = factory.createEntityManager();
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDTO, userEntity);
		userEntity.setUserRegistereDateTime(LocalDateTime.now());
		manager.getTransaction().begin();
		manager.persist(userEntity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public List<UserEntity> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readuser");
		query.getResultList();
		return (List<UserEntity>) query;
	}

	@Override
	public List<UserEntity> searchByUserState(String state) {
	EntityManager manager	=factory.createEntityManager();
	Query query =manager.createNamedQuery("searchByState");
	query.setParameter("LLRstate", state);
	List<UserEntity> sEntities =query.getResultList();
		return sEntities;
	}
}
