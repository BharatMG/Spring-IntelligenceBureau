package com.xworkz.rto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.service.RtoService;

@Controller
@RequestMapping("/")
public class RtoLoginController {

	@Autowired
	RtoService service;

	@GetMapping("rto")
	public String admin(@RequestParam String admin, Model model) {
		System.out.println(admin);
		if (admin.equals("Admin")) {
			return "admin";
		}
		if (admin.equals("LLR-Registeration")) {

			String state[] = { "Karnataka", "Maharashtra", "Kerala", "Odisha" };

			List<String> stateList = new ArrayList<String>(Arrays.asList(state));
			System.out.println(stateList);
			model.addAttribute("state", stateList);

			String Karnataka[] = { "Haveri", "Dharwad", "Bengaluru", "Mysuru" };
			String Odisha[] = { "Bhubaneswar", "Puri", "Cuttack" };
			String Maharashtra[] = { "Mumbai", "Pune", "Nagpur" };
			String Kerala[] = { "kochi", "munnar" };

			model.addAttribute("karnataka", Karnataka);
			model.addAttribute("odisha", Odisha);
			model.addAttribute("maharashtra", Maharashtra);
			model.addAttribute("kerala", Kerala);

			return "UserRegister";
		}
		if (admin.equals("SignUp")) {
			return "SignUp";
		}
		if (admin.equals("Rtologin")) {
			return "login";
		}
		return "index";
	}

	@GetMapping("login")
	public String login(@RequestParam String emailId, @RequestParam String password,
			Model model) {
		RtoDTO dto = service.login(emailId, password);
		List<UserDTO> userDTOs = service.searchByUserState(dto.getState());
		
		model.addAttribute("dto", dto);
		model.addAttribute("state", userDTOs);
		model.addAttribute("dd", dto.getFirstName().toUpperCase());
		return "profile";
	}

	@GetMapping("adminlogin")
	public String adminLogin(@RequestParam String emailId, @RequestParam String password, Model model) {
		RtoDTO dto = service.adminLogin(emailId, password);
		if (dto != null) {
			model.addAttribute("d", dto.getFirstName().toUpperCase());
			// model.addAttribute("dto", dto);
			return "adminProfile";
		} else {
			model.addAttribute("pass", "invalid password");
			return "admin";
		}
	}

//	@GetMapping("getCities")
//	public List<Object> getCities(@RequestParam String state) {
//		List<Object> list = new ArrayList<Object>();
//		if(state.equalsIgnoreCase("Karnataka")) {
//			String Karnataka[] = { "Haveri", "Dharwad", "Bengaluru", "Mysuru" };
//			list.add(Arrays.asList(Karnataka));
//		}else if(state.equalsIgnoreCase("Odisha")) {
//			String Odisha[] = { "Bhubaneswar", "Puri", "Cuttack" };
//			list.add(Arrays.asList(Odisha));
//		}else if(state.equalsIgnoreCase("Maharashtra")) {
//			String Maharashtra[] = { "Mumbai", "Pune", "Nagpur" };
//			list.add(Arrays.asList(Maharashtra));
//		}else if(state.equalsIgnoreCase("Kerala")) {
//			String Kerala[] = { "kochi", "munnar" };
//			list.add(Arrays.asList(Kerala));
//		}	
//		
//		return list;
//	}
}
