package com.tuto.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.entities.Patient;
import com.tuto.services.IPatientService;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
	
	@Autowired
	private IPatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> listAllPatients(){
		return patientService.getListAllPatients();
	}
	
	@GetMapping("/patients/{id}")
	public Patient retrievePatient(@PathVariable Long id){
		return patientService.findPatientById(id);
	}
	
	@PutMapping("/something")
	public void handle(@RequestBody String body, Writer writer) throws IOException {
		  writer.write("body received:\n");
		  writer.write(body);
	}
}
