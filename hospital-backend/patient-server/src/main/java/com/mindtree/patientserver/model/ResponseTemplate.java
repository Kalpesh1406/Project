package com.mindtree.patientserver.model;

import com.mindtree.patientserver.entity.Patient;

public class ResponseTemplate {
	
	private Doctor doctor;
	private Patient[] patient;
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient[] getPatient() {
		return patient;
	}
	public void setPatient(Patient[] patient) {
		this.patient = patient;
	}

}
