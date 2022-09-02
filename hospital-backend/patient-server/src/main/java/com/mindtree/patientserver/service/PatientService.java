package com.mindtree.patientserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.patientserver.entity.Patient;

@Service
public interface PatientService {
	
	Patient addPatient(Patient patient);
	Patient getPatientById(int id) throws Exception ;
	Patient assignToDoctorId(int id, String docName);
	List<Patient> listOfPatients();
}
