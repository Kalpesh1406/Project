package com.mindtree.patientserver;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mindtree.patientserver.entity.Patient;
import com.mindtree.patientserver.repository.PatientRepository;
import com.mindtree.patientserver.service.PatientService;



@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientServerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@BeforeEach
	void setUp() {
		patientRepository.deleteAll();
	}
	
	@Test
	void testpatientList() throws Exception {
		List<Patient>  list= new ArrayList<>();
		list.add(new Patient(1, "rahul", "Dr.patil", "2022-08-20","prescripted",1));
		list.add(new Patient(2, "aditya", "Dr.patil", "2022-08-30","prescripted",1));

		patientRepository.saveAll(list);
		
		ResultActions resultActions = mockMvc.perform(get("http://localhost:8062/patients"));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(list.size())));
	}
}


