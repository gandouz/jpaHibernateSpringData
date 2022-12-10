package com.tuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.entities.Patient;
import com.tuto.services.IPatientService;

@RestController
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
}
