package com.mindtree.patientserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.patientserver.entity.Patient;
import com.mindtree.patientserver.exception.ResourceNotFoundException;
import com.mindtree.patientserver.model.Doctor;
import com.mindtree.patientserver.repository.PatientRepository;

@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Patient addPatient(Patient patient) {
		Patient patient2 = new Patient();
		patient2 = patientRepository.save(patient);
		
		ResponseEntity<Doctor> doctoResponseEntity = restTemplate.getForEntity("http://localhost:8061/"+patient2.getVisitedDoctor(), Doctor.class);
		Doctor doctor = doctoResponseEntity.getBody();
		
		int count = patientRepository.countTotal(doctor.getName());
		System.out.println("Hello"+count);
		doctor.setNumberOfPatients(patientRepository.countTotal(doctor.getName()));
		
		ResponseEntity<Doctor> doctoResponseEntity2 = restTemplate.postForEntity("http://localhost:8061/"+"doctors", doctor, Doctor.class);
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(int id) throws Exception {
		
		Optional<Patient> patient = patientRepository.findById(id);
		Patient patient2 = new Patient();
		if (patient.isPresent()) 
		{
			patient2 = patient.get();	
		}
		else {
			throw new ResourceNotFoundException("patient", "id", patient2);
		}
		return patient2;
	}

	@Override
	public Patient assignToDoctorId(int id, String docName) {
		Optional<Patient> patient = patientRepository.findById(id);
		Patient patient2 = new Patient();
		
		if (patient.isPresent()) {
			patient2 = patient.get();
		}
		else {
			patient2.setVisitedDoctor(docName);
		}
		return patientRepository.save(patient2);
	}

	@Override
	public List<Patient> listOfPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

}
