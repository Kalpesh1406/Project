package com.mindtree.doctorserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doctorserver.entity.Doctor;
import com.mindtree.doctorserver.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctors")
	ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		return doctorService.addDoctor(doctor);
		
	}
	
	@GetMapping("/doctors")
	List<String> getDoctors(){
		return doctorService.getDoctors();
		
	}
	
	@GetMapping("/{docName}")
	Doctor getDoctorByName(@PathVariable String docName) {
		return doctorService.getDoctorByName(docName);
		
	}
	
	@GetMapping("/doctors/")
	List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
		
	}
	
	@GetMapping("doctors/get/{id}")
	Doctor getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
		
	}

}
