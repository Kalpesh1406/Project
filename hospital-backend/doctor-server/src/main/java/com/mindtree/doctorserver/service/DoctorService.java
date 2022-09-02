package com.mindtree.doctorserver.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.doctorserver.entity.Doctor;

@Service
public interface DoctorService {
	
	ResponseEntity<Doctor> addDoctor(Doctor doctor);
	List<String> getDoctors();
	Doctor getDoctorByName(String docName);
	List<Doctor> getAllDoctors();
	Doctor getDoctorById(int id);

}
