package com.tuto.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tuto.entities.Patient;

public interface IPatientService {
	public Patient createPatient(Patient patient);
	public List<Patient> getListAllPatients();
	public Patient findPatientById(Long id);
	public List<Patient> findPatientsByNameContains(String name);
	public List<Patient> findPatientsByCovid19Vaccinated(boolean covid19Vaccinated);
	public List<Patient> findPatientsByNameContainsAndCovid19Vaccinated(String name, boolean covid19Vaccinated);
	public void deleteAllPatients();
	public void deletePatientById(Long id);
	public Page<Patient> getListAllPatientsByPage(int page, int size);
	public Page<Patient> findPatientsByNameContainsByPage(String name, int page, int size);
	
	public List<Patient> findAllPatientsWithTheirsRendezVous();

}
