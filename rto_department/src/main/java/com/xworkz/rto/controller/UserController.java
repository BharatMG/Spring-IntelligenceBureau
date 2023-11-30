package com.xworkz.rto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.service.RtoService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	RtoService service;

	@PostMapping("user")
	public String userSave(Model model, @ModelAttribute UserDTO userDTO) {
		List<UserDTO> dtos = service.readUser();
		System.out.println("usersave controller method");
		for (UserDTO userDTO2 : dtos) {
			if (userDTO2.getEmail().equalsIgnoreCase(userDTO.getEmail())) {
				model.addAttribute("error", "* email already exist");
				if (userDTO2.getContactNumber() == userDTO.getContactNumber()) {
					model.addAttribute("error1", "* number is already exists");
					return "UserRegister";
				}
			} else {
				boolean save = service.checkSave(userDTO);

				String state[] = { "karnataka", "Ap", "tamilNadu", "Goa" };
				List<String> stateList = new ArrayList<String>(Arrays.asList(state));
				System.out.println(stateList);
				model.addAttribute("dto", userDTO);
				model.addAttribute("message", "successfully registered");
				model.addAttribute("applicationNumber", "applicationNumber is " + userDTO.getApplicationNumber());
				return "UserRegister";
			}
		}
		return "UserRegister";
	}

	@GetMapping("userState")
	public String userState(@RequestParam String state, Model model) {
		List<UserDTO> userDTOs = service.searchByUserState(state);
		model.addAttribute("state", userDTOs);
		return "profile";
	}

	@GetMapping("appStaus")
	public String userStatus(@RequestParam String apporcontact, String dob, Model model) {
		if (dob != null) {
			UserDTO userDTO = service.userLogin(apporcontact, dob);
			model.addAttribute("d", userDTO);
			return "UserProfile";
		} else {
			model.addAttribute("msg", "invalid login");
			return "LLR-status";
		}
	}
	
	@GetMapping("updateUserStatus")
	public String updateStatus(@RequestParam int id, /* @RequestParam String state, */ Model model) {
//	boolean update	=service.updateStatus(applicationNumber);
	boolean update=service.updateId(id);
		if (update == true) {
			model.addAttribute("updateMessage", "updated successfully..........");
			model.addAttribute("u",update);
	//	List<UserDTO>	userDTOs=service.searchByUserState(state);
	//	model.addAttribute("state", userDTOs);)
			return "profile";
		} else {
			model.addAttribute("updateMessage", "...not updated ..........");
			return "profile";
		}
	//	return "UserProfile";
	}
}
