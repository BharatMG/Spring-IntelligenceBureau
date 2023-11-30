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
		userEntity.setStatus("pending");
		// userEntity.setUserRegistereDateTime(LocalDateTime.now());
		manager.getTransaction().begin();
		manager.persist(userEntity);
		System.out.println("user repo saving method");
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public List<UserEntity> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readuser");
		List<UserEntity> list = query.getResultList();
		return list;
	}

	@Override
	public List<UserEntity> searchByUserState(String state) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("searchByState");
		query.setParameter("LLRstate", state);
		List<UserEntity> sEntities = query.getResultList();
		return sEntities;
	}

	@Override
	public UserEntity userLogin(String apporcontact, String dob) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("userlogin");
		query.setParameter("app", apporcontact);
		// query.setParameter("contact", contactNumber);
		query.setParameter("dob", dob);
		return (UserEntity) query.getSingleResult();
	}

	@Override
	public boolean updateStatus(String applicationNumber) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("updateStatus");
		query.setParameter("appNum",applicationNumber );
		manager.getTransaction().begin();
		int row = query.executeUpdate();
		manager.getTransaction().commit();
		return row > 0;
	}

	@Override
	public boolean updateById(int id) {
		EntityManager manager = factory.createEntityManager();
		UserEntity entity=manager.find(UserEntity.class,id);
	if (entity!=null) {
		entity.setStatus("approved");
		manager.getTransaction().begin();
	//	BeanUtils.copyProperties(dto, entity);
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}else {
		System.out.println("invalid id");
		return false;
	}
		//return false;
	}

	
}