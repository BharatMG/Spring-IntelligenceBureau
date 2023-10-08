package com.xworkz.intelligenceBureau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.intelligenceBureau.service.IntelligenceBureauService;

@Controller
@RequestMapping("/")
public class IntelligenceBureauDeleteController {

	@Autowired
	IntelligenceBureauService service;

	@GetMapping("delete")
	public String deleteById(@RequestParam int id, Model model) {
		System.out.println("this is Delete method");
		System.out.println(id);
		boolean delete = service.deleteById(id);
		if (delete == true) {
			model.addAttribute("success", "record deleted successfully...");
			return "Findall";
		} else {
			model.addAttribute("Fail", "record not delete");
			return "Findall";
		}
	}

	@GetMapping("deleteEmail")
	public String deleteByEmail(@RequestParam String email, Model model) {
		boolean dtos = service.deleteByEmail(email);
		System.out.println("data deleted-------" + email);
//		model.addAttribute("dto", dtos);
		if (dtos) {
			model.addAttribute("success", "record deleted successfully...");
			return "findByEmail";
		} else {
			model.addAttribute("Fail", "record not delete");
			return "findByEmail";
		}

	}

	@GetMapping("deleteByName")
	public String deleteByName(@RequestParam String officerName, Model model) {
		boolean dtos = service.deleteByName(officerName);
		System.out.println("data delete successfully:" + officerName);
//		model.addAttribute("dto", dtos);
		if (dtos==true) {
			model.addAttribute("success", "record deleted successfully...");
			return "findByName";
		} else {
			model.addAttribute("Fail", "record not delete");
			return "findByName";
		}
	}

	@GetMapping("deleteNumber")
	public String deleteByMobileNumber(@RequestParam Long mobileNumber, Model model) {
System.out.println("deleteByMobileNumber controller method started");
			boolean dtos=service.deleteByMobileNumber(mobileNumber);
			System.out.println("data delete successfully:" + mobileNumber);

			if (dtos==true) {
				model.addAttribute("success", "record deleted successfully...");
				return "findByMobileNumber";		
			}else {
				model.addAttribute("Fail", "record not delete");	
		return "findByMobileNumber";
			}
	}
}
