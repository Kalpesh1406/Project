package com.mindtree.patientserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.patientserver.entity.Patient;
import com.mindtree.patientserver.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping("/")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
		
	}
	
	@GetMapping
	public List<Patient> listOfPatients() {
		return patientService.listOfPatients();
		
	}

	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable int id) throws Exception {
		return patientService.getPatientById(id);
		
	}
	
	@PutMapping("/{id}/{docName}")
	public Patient assignToDoctorId(@PathVariable int id, @PathVariable String docName) {
		return patientService.assignToDoctorId(id, docName);
		
	}
}
