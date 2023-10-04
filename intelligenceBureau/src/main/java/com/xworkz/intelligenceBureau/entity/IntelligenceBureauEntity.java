package com.xworkz.intelligenceBureau.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "intelligenceBureau_info")
@NamedQuery(name="readAll", query="select e from IntelligenceBureauEntity e")
public class IntelligenceBureauEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String officerName;
	private String designation;
	private String gender;
	private String email;
	private long mobileNumber;
	private String isMarried;
	private String permanentAddress;
	private String workingAddress;
	private double basicPayScale;


}
