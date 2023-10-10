package com.xworkz.intelligenceBureau.controller;

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
public class IntelligenceBureauUpdateController {

	@Autowired
	IntelligenceBureauService service;

	@GetMapping("update")
	public String update(@RequestParam int id, Model model) {
		System.out.println("id" + id);
		IntelligenceBureauDTO dto = service.findById(id);
		if (dto == null) {
			model.addAttribute("message", "message not found");
			return "update";
		} else {
			model.addAttribute("dto", dto);
			return "update";
		}
	}

	@PostMapping("update")
	public String updateById(@ModelAttribute IntelligenceBureauDTO dto, Model model) {
		boolean update = service.updateById(dto);
if (update==true) {
	model.addAttribute("updateMessage", "updated successfully..........");
	return "Findall";
}else {
	model.addAttribute("updateMessage", "...not updated ..........");
	return "update";
	}
}
}