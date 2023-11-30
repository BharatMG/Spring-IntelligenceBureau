package com.xworkz.rto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.mail.MailService;
import com.xworkz.rto.service.RtoService;

@Controller
@RequestMapping("/")
public class RtoLoginController {

	@Autowired
	private MailService mailService;

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
		if (admin.equals("LLR-Application Status")) {
			return "LLR-status";
		}
		if (admin.equals("Forgetten Password")) {
			return "forgetUserLogin";

		}
		return "index";
	}

	@PostMapping("login")
	public String login(@RequestParam String emailId, @RequestParam String password, Model model) {
		RtoDTO dto = service.login(emailId, password);
		List<UserDTO> userDTOs = service.searchByUserState(dto.getState()); // Collections.sort(userDTOs,);
		if (dto != null) {
			model.addAttribute("dto", dto);
			model.addAttribute("state", userDTOs);
			model.addAttribute("dd", dto.getFirstName().toUpperCase());
			return "profile";
		} else {
			model.addAttribute("pass", "invalid password");
			return "login";
		}
	}

	@PostMapping("checkemail")
	public String forgetPassword(
			@ModelAttribute RtoDTO dto, /* HttpServletRequest req, */ @RequestParam String rtoOtp, String otp,
			@RequestParam String emailId, /* @RequestParam String password, @RequestParam String confirmPassword, */
			Model model) {
		System.out.println("otp is      +" + otp);
		if (otp.equalsIgnoreCase("sendOtp")) {
			List<RtoDTO> dtos = service.readAll();
			for (RtoDTO rtoDTO : dtos) {
				if (rtoDTO.getEmailId().equals(emailId)) {
					dto = rtoDTO;
					model.addAttribute("sendOtp", "otp sent successfully");
					int randomNumber = (int) ((Math.random() * 90000) + 10000);
					boolean sendOTP = mailService.mailSend(emailId, String.valueOf(randomNumber));
					if (sendOTP) {
						service.updateOTPbyId(dto, String.valueOf(randomNumber)); // update otp method
						model.addAttribute("emailId", emailId);
						model.addAttribute("pass", "otp sent successfully");
						return "forgetRtoLogin";
					}
				} else {
					model.addAttribute("err", "Error while sending otp");
				}
			}
			return "forgetRtoLogin";
		}
		if (otp.equalsIgnoreCase("next")) {
			List<RtoDTO> dtos = service.readAll();
			List<RtoDTO> dtos2 = dtos.stream().filter(item -> item.getEmailId().equalsIgnoreCase(emailId))
					.collect(Collectors.toList());
			for (RtoDTO rtoDTO : dtos2) {
				if (rtoDTO.getRtoOtp().equalsIgnoreCase(rtoOtp)) {
					// HttpSession session = req.getSession();
					// session.setAttribute("email", emailId);

					return "ResetPassword";
				} else {
					model.addAttribute("invalid", "invalid otp");
					return "forgetRtoLogin";
				}
			}
		}
		/*
		 * if (otp.equalsIgnoreCase("submit")) { List<RtoDTO> dtos = service.readAll();
		 * List<RtoDTO> dtos2 = dtos.stream().filter(item ->
		 * item.getEmailId().equalsIgnoreCase(emailId)) .collect(Collectors.toList());
		 * service.updatePassword(dto, password, confirmPassword);
		 * model.addAttribute("valid", "updatePassword successfully"); return
		 * "ResetPassword"; } else { model.addAttribute("valid",
		 * "updatePassword not valid"); return "ResetPassword";
		 */
		return "forgetRtoLogin";
	}

	@PostMapping("updatePassword")
	public String updatePassword(@ModelAttribute RtoDTO dto, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {
		/*
		 * List<RtoDTO> dtos = service.readAll(); for (RtoDTO rtoDTO : dtos) {
		 * System.out.println(rtoDTO);
		 */
		if (dto != null) {
			service.updatePassword(dto, password, confirmPassword);
			System.out.println("updatePassword method invoked");
			model.addAttribute("valid", "updatePassword successfully");
			return "ResetPassword";
		} else {
			model.addAttribute("valid", "updatePassword not valid");
			return "ResetPassword";
		}
		// dto = rtoDTO;
		// return "forgetRtoLogin";

	}

	@PostMapping("adminlogin")
	public String adminLogin(@RequestParam String emailId, Model model) {

		RtoDTO dto = null;
		List<RtoDTO> dtos = service.readAll();
		for (RtoDTO rtoDTO : dtos) {
			if (rtoDTO.getEmailId().equals(emailId)) {
				dto = rtoDTO;
				// break;
			}
		}
		if (dto != null) {
			System.out.println("***************************" + dto.getEmailId() + "*************************");
			int randomNumber = (int) ((Math.random() * 90000) + 10000);
			boolean sendOTP = mailService.mailSend(emailId, String.valueOf(randomNumber));
			if (sendOTP) {
				service.updateOTPbyId(dto, String.valueOf(randomNumber));
				model.addAttribute("emailId", emailId);
				model.addAttribute("pass", "otp sent successfully");
			} else {
				model.addAttribute("err", "Error while sending otp");
			}
		} else {
			model.addAttribute("err", "Invalid emailId");
		}
		return "admin";
	}

	@PostMapping("verifyotp")
	public String getOtp(@RequestParam String emailId, @RequestParam String rtoOtp, Model model) {
		RtoDTO dto = service.adminLogin(emailId, rtoOtp);
		if (dto != null) {
			return "adminProfile";
		} else {
			model.addAttribute("err", "Invalid Otp");
			return "admin";
		}
		/*
		 * if (send == true) { System.out.println("mail Send Sucessfully");
		 * model.addAttribute("send", " mail Send Successfully"); return "admin"; }
		 */
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
