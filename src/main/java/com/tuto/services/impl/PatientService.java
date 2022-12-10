package com.tuto.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tuto.entities.Patient;
import com.tuto.repositories.PatientRepository;
import com.tuto.services.IPatientService;

import jakarta.transaction.Transactional;

@Service
@Transactional
class PatientService implements IPatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);

	}

	@Override
	public List<Patient> getListAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findPatientById(Long id) throws NoSuchElementException {
		return patientRepository.findById(id).get();
	}

	@Override
	public List<Patient> findPatientsByNameContains(String name) {
		return patientRepository.findByNameContains(name);
	}

	@Override
	public void deleteAllPatients() {
		patientRepository.deleteAll();
		
	}

	@Override
	public List<Patient> findPatientsByCovid19Vaccinated(boolean covid19Vaccinated) {
		return patientRepository.findByCovid19Vaccinated(covid19Vaccinated);
	}

	@Override
	public List<Patient> findPatientsByNameContainsAndCovid19Vaccinated(String name, boolean covid19Vaccinated) {
		return patientRepository.findByNameContainsAndCovid19Vaccinated(name, covid19Vaccinated);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
		
	}

	@Override
	public Page<Patient> getListAllPatientsByPage(int page, int size) {
		return patientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Patient> findPatientsByNameContainsByPage(String name, int page, int size) {
		return patientRepository.findByNameContains(name, PageRequest.of(page, size));
	}

	@Override
	public List<Patient> findAllPatientsWithTheirsRendezVous() {
		return patientRepository.findAllPatientsWithTheirsRendezVous();
	}

}
