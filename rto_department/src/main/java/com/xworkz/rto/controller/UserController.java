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
		boolean save = service.checkSave(userDTO);

		String state[] = { "karnataka", "Ap", "thamilNadu", "Goa" };
		List<String> stateList = new ArrayList<String>(Arrays.asList(state));
		/*
		 * stateList.add(null); stateList.add("karnataka"); stateList.add("Ap");
		 * stateList.add("karnataka"); stateList.add("karnataka");
		 */
		System.out.println(stateList);
		model.addAttribute("dto", userDTO);
		return "UserProfile";
	}

	@GetMapping("userState")
	public String userState(@RequestParam String state, Model model) {
		List<UserDTO> userDTOs = service.searchByUserState(state);
		model.addAttribute("state", userDTOs);
		return "profile";

	}
}
