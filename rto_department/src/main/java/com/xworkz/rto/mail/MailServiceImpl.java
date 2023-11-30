package com.xworkz.rto.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.rto.configuration.MailConfig;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailConfig config;

	@Override
	public boolean mailSend(String email, String rtoOtp) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			// message.setFrom("hareeshahr.xworkz@gmail.com");
			message.setTo(email);
			message.setSubject("OTP for login");
			message.setText("Your otp for admin login is:" + rtoOtp);
			config.mailConfig().send(message);
			System.out.println("mail send successfully");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	Object ob = new Object();

}
