package com.xworkz.rto.repository;

import java.util.List;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.RtoEntity;

public interface RtoRepository {
	
	public abstract boolean onSave(RtoDTO dto);
	
	public abstract List<RtoEntity> readAll();
	 
	public abstract RtoEntity login(String emailId,String password);
	
	public abstract RtoEntity adminLogin(String emailId,String password);
	
	public abstract List<RtoEntity> searchByState(String state);
	
	
}
