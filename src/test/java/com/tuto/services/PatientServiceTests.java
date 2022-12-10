package com.tuto.services;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tuto.entities.Patient;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PatientServiceTests {

	@Autowired
	IPatientService patientService;

	@BeforeAll
	void setUp() {
		patientService.createPatient(new Patient(null, "Loic", new Date(), true, null));
		patientService.createPatient(new Patient(null, "François", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Antoine", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Rudi", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Clementine", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Sarah", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Pascal", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Rudi", new Date(), true, null));
	}

	@AfterAll()
	void shutDown() {
		patientService.deleteAllPatients();
	}

	@Test
	void testCreatePatient() {
		Patient created = patientService.createPatient(new Patient(null, "Romain", new Date(), false, null));
		assertNotEquals(created.getId(), null);
	}

	@Test
	void testGetListAllPatients() {
		List<Patient> listPatients = patientService.getListAllPatients();
		assertNotEquals((Integer) listPatients.size(), null);
	}

//	@Test
//	void testFindPatientById() {
//		Patient patient = patientService.findPatientById(2L);
//		assertNotEquals(patient, null);
//	}
//
//	@Test
//	void testFindpatientByNameContains() {
//		String substring = "i";
//		List<Patient> patients = patientService.findPatientsByNameContains(substring);
//		patients.forEach(p -> {
//			assertEquals(p.getName().contains(substring), true);
//		});
//	}
//
//	@Test
//	void testFindPatientsByCovid19Vaccinated() {
//		boolean covid19Vaccinated = true;
//		List<Patient> patients = patientService.findPatientsByCovid19Vaccinated(covid19Vaccinated);
//		patients.forEach(p -> {
//			assertEquals(p.isCovid19Vaccinated(), covid19Vaccinated);
//		});
//	}
//
//	@Test
//	void testFindPatientsByNameContainsAndCovid19Vaccinated() {
//		String substring = "i";
//		boolean covid19Vaccinated = true;
//		List<Patient> patients = patientService.findPatientsByNameContainsAndCovid19Vaccinated(substring,
//				covid19Vaccinated);
//		patients.forEach(p -> {
//			assertEquals(p.getName().contains(substring), true);
//			assertEquals(p.isCovid19Vaccinated(), covid19Vaccinated);
//		});
//	}

//	@Test
//	void testDeletePatientById() throws Exception {
//		Long id = 2L;
//		patientService.deletePatientById(id);
//		Patient patient = null;
//		try {
//			patient = patientService.findPatientById(id);
//		} catch (Exception e) {
//			assertThat(e)
//            .isInstanceOf(NoSuchElementException.class)
//            .hasMessage("No value present");
//		}
//		assertEquals(patient, null);
//	}

//	@Test
//	void testGetListAllPatientsByPage() {
//		int page = 0;
//		int size = 2;
//		Page<Patient> pagePatients = patientService.getListAllPatientsByPage(page, size);
//		assertEquals(((Integer) pagePatients.getSize()) <= size, true);
//	}
//	
//	@Test
//	void testFindpatientByNameContainsByPage() {
//		int page = 0;
//		int size = 2;
//		String substring = "i";
//		Page<Patient> pagePatients = patientService.findPatientsByNameContainsByPage(substring, page, size);
//		assertEquals(((Integer) pagePatients.getSize()) <= size, true);
//	}
	
}
