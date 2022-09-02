package com.mindtree.doctorserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mindtree.doctorserver.entity.Doctor;
import com.mindtree.doctorserver.repository.DoctorRepository;

@Component
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public ResponseEntity<Doctor> addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Doctor>(doctorRepository.save(doctor),HttpStatus.CREATED);
	}

	@Override
	public List<String> getDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAllByName();
	}

	@Override
	public Doctor getDoctorByName(String docName) {
		// TODO Auto-generated method stub
		return doctorRepository.getDoctorByName(docName);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

}
