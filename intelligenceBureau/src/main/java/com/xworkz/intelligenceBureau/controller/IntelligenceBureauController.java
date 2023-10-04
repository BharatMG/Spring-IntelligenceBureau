package com.xworkz.intelligenceBureau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
}
