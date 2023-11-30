package com.xworkz.rto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.repository.RtoRepository;
import com.xworkz.rto.repository.RtoUserRepository;

@Service
public class RtoServiceImplementation implements RtoService {

	public RtoServiceImplementation() {
		System.out.println("RtoServiceImplementation constructor");
	}

	@Autowired
	RtoRepository repository;

	@Autowired
	RtoUserRepository userrepo;

	@Override
	public Set<ConstraintViolation<RtoDTO>> validateAndCheck(RtoDTO dto) {

		/*
		 * List<RtoEntity> entities=repository.readAll(); for (RtoEntity rtoEntity :
		 * entities) { if (rtoEntity.getEmailId().equalsIgnoreCase(dto.getEmailId())) {
		 * return entities; } }
		 */

		System.out.println("onSave method in service");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RtoDTO>> violations = validator.validate(dto);
		if (violations.isEmpty()) {
			if (dto != null) {
				if (dto.getPassword().equals(dto.getConfirmPassword())) {
					repository.onSave(dto);
				}
			}
			return violations;
		} else {
			System.out.println("Violations Present");
			return violations;
		}
	}

	@Override
	public List<RtoDTO> readAll() {
		System.out.println("readAll method in service");
		List<RtoEntity> entities = repository.readAll();
		List<RtoDTO> dtos = new ArrayList<RtoDTO>();
		for (RtoEntity rtoEntity : entities) {
			RtoDTO dto = new RtoDTO();
			// System.err.println("Before RtoEntity " + rtoEntity);

			BeanUtils.copyProperties(rtoEntity, dto);
			// System.out.println("After RtoDto " + dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public RtoDTO login(String emailId, String password) {
		RtoEntity entity = repository.login(emailId, password);
		RtoDTO dto = new RtoDTO();
		BeanUtils.copyProperties(entity, dto);
		if (dto.getEmailId().equalsIgnoreCase(emailId) && dto.getPassword().equalsIgnoreCase(password)) {
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public RtoDTO adminLogin(String emailId, String rtoOtp) {

		RtoEntity entity1 = repository.adminLogin(emailId, rtoOtp);
		if (entity1 != null) {
			RtoDTO dto = new RtoDTO();
			BeanUtils.copyProperties(entity1, dto);
			if (dto.getEmailId().equalsIgnoreCase(emailId) && dto.getRtoOtp().equalsIgnoreCase(rtoOtp)) {
				return dto;
			} else {
				System.out.println("Invalid email or password");
				return null;
			}
		} else {
			System.out.println("entity is not null");
			return null;
		}
	}

	@Override
	public List<RtoDTO> searchByState(String state) {

		List<RtoDTO> dtos = new ArrayList<RtoDTO>();
		List<RtoEntity> entities = repository.searchByState(state);
		for (RtoEntity rtoEntity : entities) {
			RtoDTO dto = new RtoDTO();
			BeanUtils.copyProperties(rtoEntity, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public boolean checkSave(UserDTO userDTO) {

		if (userDTO != null) {
			int randomNumber = (int) ((Math.random() * 900) + 100);
			String otp = String.valueOf(randomNumber);
			String code = null;
			if (userDTO.getState().equals("Karnataka")) {
				code = "KA2023LLR" + otp;
			}
			if (userDTO.getState().equals("Kerala")) {
				code = "KL2023LLR" + otp;
			}
			if (userDTO.getState().equals("Maharashtra")) {
				code = "MH2023LLR" + otp;
			}
			if (userDTO.getState().equals("Odisha")) {
				code = "MH2023LLR" + otp;
			}
			userDTO.setApplicationNumber(code);
			boolean check = userrepo.userSave(userDTO);
			return true;
		}
		System.out.println("user data is null");
		return false;
	}

	@Override
	public List<UserDTO> readUser() {
		List<UserEntity> entities = userrepo.readAll();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (UserEntity userEntity : entities) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public List<UserDTO> searchByUserState(String state) {
		List<UserEntity> entities = userrepo.searchByUserState(state);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (UserEntity userEntity : entities) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public UserDTO userLogin(String apporcontact, String dob) {
		UserEntity userEntity = userrepo.userLogin(apporcontact, dob);
		if (userEntity != null) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			return userDTO;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateStatus(String applicationNumber) {
		userrepo.updateStatus(applicationNumber);
		return true;
	}

	@Override
	public boolean updateId(int id) {
		boolean update = userrepo.updateById(id);
		return update;
	}

	@Override
	public void updateOTPbyId(RtoDTO rtoDTO, String otp) {
		rtoDTO.setRtoOtp(otp);
		repository.updateOTPbyId(rtoDTO);
	}

	@Override
	public void updatePassword(RtoDTO rtoDTO, String password, String confirmPassword) {
		rtoDTO.setPassword(password);
		rtoDTO.setConfirmPassword(confirmPassword);
		repository.updatePassword(rtoDTO);

	}
}