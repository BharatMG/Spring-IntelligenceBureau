package com.xworkz.intelligenceBureau.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class IntelligenceBureauDTO {
	
	private int id;
	private String officerName;
	private String designation;
	private String gender;
	private String email;
	private long mobileNumber;
	private String isMarried;
	private String permanentrAddress;
	private String workingAddress;
	private double basicPayScale;
	
	

}
