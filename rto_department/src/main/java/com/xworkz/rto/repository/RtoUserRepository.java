package com.xworkz.rto.repository;

import java.util.List;

import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.UserEntity;

public interface RtoUserRepository {
	
	public abstract boolean userSave(UserDTO userDTO);
	
	public abstract List<UserEntity> readAll();
	
	public abstract List<UserEntity> searchByUserState(String state);

}
