package com.mindtree.patientserver.model;


public class Doctor {
	
	private int id;
	private String name;
	private String gender;
	private String specialist;
	private int numberOfPatients;
	private int age;
	
	public Doctor() {
		super();
	}

	public Doctor(int id, String name, String gender, String specialist, int numberOfPatients, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.specialist = specialist;
		this.numberOfPatients = numberOfPatients;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getNumberOfPatients() {
		return numberOfPatients;
	}

	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
