package com.xworkz.intelligenceBureau.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name = "intelligenceBureau_info")
@NamedQueries({
	@NamedQuery(name="readAll", query="select e from IntelligenceBureauEntity e") ,
	@NamedQuery(name ="findByName", query = "select e from IntelligenceBureauEntity e where e.officerName=:name"),
	@NamedQuery(name ="findByEmail", query = "select e from IntelligenceBureauEntity e where e.email=:email")
})
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
