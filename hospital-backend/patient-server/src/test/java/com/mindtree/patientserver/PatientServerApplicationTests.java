package com.mindtree.patientserver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.patientserver.entity.Patient;
import com.mindtree.patientserver.repository.PatientRepository;

@SpringBootTest
class PatientServerApplicationTests {

	@Autowired
	PatientRepository patientRepository ;
	
	@Test
	void testReadAll() {
		List<Patient> list = patientRepository.findAll();
		assertThat(list).size().isGreaterThan(0);		
	}
	

}
