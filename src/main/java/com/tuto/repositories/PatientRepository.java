package com.tuto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tuto.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	public List<Patient> findByNameContains(String name);
	public List<Patient> findByCovid19Vaccinated(boolean covid19Vaccinated);
	public List<Patient> findByNameContainsAndCovid19Vaccinated(String name, boolean covid19Vaccinated);
	public Page<Patient> findByNameContains(String name, Pageable pageable);
	
	/*
	 * One Patient ToMany RendezVous
	 * Solution for get list of RendezVous even the fetchType is LAZY
	 * if not used, a LazyInitializationException is throwed
	 */
	@Query("select p from Patient p left join fetch p.listRendezVous")
	public List<Patient> findAllPatientsWithTheirsRendezVous();

}
