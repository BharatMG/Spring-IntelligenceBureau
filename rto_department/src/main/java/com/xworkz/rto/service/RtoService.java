package com.xworkz.rto.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDTO;

public interface RtoService {

	public abstract Set<ConstraintViolation<RtoDTO>> validateAndCheck(RtoDTO dto);

	public abstract List<RtoDTO> readAll();

	public abstract RtoDTO login(String emailId, String password);

	public abstract RtoDTO adminLogin(String emailId, String rtoOtp);

	public abstract List<RtoDTO> searchByState(String state);

	public abstract boolean checkSave(UserDTO userDTO);

	public abstract List<UserDTO> readUser();

	public abstract List<UserDTO> searchByUserState(String state);

	public abstract UserDTO userLogin(String apporcontact, String dob);

	public abstract boolean updateStatus(String applicationNumber);

	public abstract boolean updateId(int id);

	public abstract void updateOTPbyId(RtoDTO rtoDTO, String otp);

	public abstract void updatePassword(RtoDTO rtoDTO, String password, String confirmPassword);

}
