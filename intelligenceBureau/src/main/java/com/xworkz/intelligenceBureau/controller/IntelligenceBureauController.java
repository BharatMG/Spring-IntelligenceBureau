package com.xworkz.intelligenceBureau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.service.IntelligenceBureauService;

@Controller
@RequestMapping("/")
public class IntelligenceBureauController {
	@Autowired
	IntelligenceBureauService service;

	@PostMapping("save")
	public String onSave(@ModelAttribute IntelligenceBureauDTO dto, Model model) {
		System.out.println(dto);
		model.addAttribute("dto", dto);
		boolean save = service.onSave(dto);
		System.out.println(save);
		return "success";
	}
	
	@GetMapping("read")
	public String findall(Model model) {
	List<IntelligenceBureauDTO> dto =	service.readAll();
		model.addAttribute("dtos",dto);
		return "Findall";	
	}
	
	@GetMapping("getId")
	public String getById(@RequestParam int id,Model model) {
	IntelligenceBureauDTO d =	service.findById(id);
	System.out.println("controller in getId"+d);
	model.addAttribute("dto", d);
		return "findById";	
	}
	
	@GetMapping("getByName")
	public String getbyName(@RequestParam String officerName,Model model) {
		List<IntelligenceBureauDTO> dtos=service.findByName(officerName);
		model.addAttribute("dto", dtos);
		System.out.println("get the Names:"+dtos);
		return "findByName";
	}
	
	@GetMapping("getEmail")
	public String getByEmail(@RequestParam String email,Model model) {
	List<IntelligenceBureauDTO> dtos =	service.findByEmail(email);
	model.addAttribute("dto", dtos);	
	System.out.println("get the email:"+dtos);	
	return "findByEmail";

	}
}
