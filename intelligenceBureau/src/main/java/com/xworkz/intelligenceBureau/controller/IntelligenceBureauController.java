package com.xworkz.intelligenceBureau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.intelligenceBureau.dto.IntelligenceBureauDTO;
import com.xworkz.intelligenceBureau.service.IntelligenceBureauService;

@Component
@RequestMapping("/")
public class IntelligenceBureauController {
	@Autowired
	IntelligenceBureauService service;

	@PostMapping("save")
	public String onSave(@ModelAttribute IntelligenceBureauDTO dto, Model model) {
		model.addAttribute("dto", dto);
		System.out.println(dto);
		boolean save = service.onSave(dto);
		System.out.println(save);
		return "save.jsp";

	}
}
