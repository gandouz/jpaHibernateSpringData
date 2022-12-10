package com.tuto;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.tuto.entities.Consultation;
import com.tuto.entities.Medecin;
import com.tuto.entities.Patient;
import com.tuto.entities.RendezVous;
import com.tuto.entities.Specialite;
import com.tuto.entities.StatusRDV;
import com.tuto.entities2.Role;
import com.tuto.entities2.User;
import com.tuto.entities3.Enseignant;
import com.tuto.entities3.Etudiant;
import com.tuto.services.IConsultationService;
import com.tuto.services.IMedecinService;
import com.tuto.services.IPatientService;
import com.tuto.services.IRendezVousService;
import com.tuto.services2.IRoleService;
import com.tuto.services2.IUserService;
import com.tuto.services2.impl.UserService;
import com.tuto.services3.IPersonneService;

@SpringBootApplication
public class JpaHibernateSpringDataApplication implements CommandLineRunner {

	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IMedecinService medecinService;
	
	@Autowired
	private IRendezVousService rendezVousService;
	
	@Autowired
	private IConsultationService consultationService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPersonneService personneService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	
	Logger logger = LoggerFactory.getLogger(JpaHibernateSpringDataApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateSpringDataApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		// persist some entries
		logger.info("Persist some entries");
		patientService.createPatient(new Patient(null, "Loic", new Date(), true, null));
		patientService.createPatient(new Patient(null, "François", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Antoine", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Rudi", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Clementine", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Sarah", new Date(), true, null));
		patientService.createPatient(new Patient(null, "Pascal", new Date(), false, null));
		patientService.createPatient(new Patient(null, "Rudi", new Date(), true, null));
		
		medecinService.createMedecin(new Medecin(null, "Dr Dre", "dr.dre@gmail.com", Specialite.ESTHETIQUE, null));
		medecinService.createMedecin(new Medecin(null, "Dr Mario", "dr.mario@gmail.com", Specialite.CARDIO, null));
		medecinService.createMedecin(new Medecin(null, "Dr Peyre", "dr.peyre@gmail.com", Specialite.OPHTALMO, null));
		medecinService.createMedecin(new Medecin(null, "Dr Gandouz", "dr.gandouz@gmail.com", Specialite.GENERALISTE, null));
		
		Patient p1 = patientService.findPatientById(1L);
		Patient p2 = patientService.findPatientById(2L);
		Patient p3 = patientService.findPatientById(3L);
		Medecin m1 = medecinService.findMedecinById(1L);
		Medecin m2 = medecinService.findMedecinById(2L);
		Medecin m3 = medecinService.findMedecinById(3L);
		RendezVous r1 = rendezVousService.createRendezVous(new RendezVous(null, new Date(), StatusRDV.PENDING, p1, m1, null));
		RendezVous r2 = rendezVousService.createRendezVous(new RendezVous(null, new Date(), StatusRDV.PENDING, p1, m2, null));
		RendezVous r3 = rendezVousService.createRendezVous(new RendezVous(null, new Date(), StatusRDV.PENDING, p2, m3, null));
		consultationService.createConsultation(new Consultation(null, r1.getDate(), "Shampoing special chute des cheveux ..", r1));
		consultationService.createConsultation(new Consultation(null, r2.getDate(), "Bilan a faire ..", r2));
		consultationService.createConsultation(new Consultation(null, r3.getDate(), "Topographie a faire ..", r3));
		
		
		// get all entries
		logger.info("Get all entries");
		AtomicInteger i = new AtomicInteger();
		patientService.getListAllPatients().forEach(p->{
			i.incrementAndGet();
			//p = patientService.findPatientById(p.getId());
			//p.setListRendezVous(p.getListRendezVous());
			logger.info("Patient number " + i + " : " + p);
		});
		AtomicInteger i2 = new AtomicInteger();
		medecinService.getListAllMedecins().forEach(m->{
			i2.incrementAndGet();
			logger.info("Medecin number " + i2 + " : " + m);			
		});
		AtomicInteger i3 = new AtomicInteger();
		rendezVousService.getListAllRendezVous().forEach(r->{
			i3.incrementAndGet();
			logger.info("RDV number " + i3 + " : " + r);
		});
		AtomicInteger i4 = new AtomicInteger();
		consultationService.getListAllConsultations().forEach(c->{
			i4.incrementAndGet();
			logger.info("Consultation number " + i4 + " : " + c);
		});
		

		// find an entrie with id = 3
		logger.info("Find an entrie with id = 3");
		Long id = 3L;
		Patient patient = patientService.findPatientById(id);
		logger.info("Patient found with id = " + id + " : " + patient);
		
		// find entries by Name contains
		String substring = "i";
		logger.info("Find entries by Name contains = " + substring);
		List<Patient> patients = patientService.findPatientsByNameContains(substring);
		patients.forEach(p->{
			logger.info("Patient found : " + p);
		});
		
		// find entries by Boolean value
		boolean covid19Vaccinated = true;
		logger.info("Find entries by covid19Vaccinated = " + covid19Vaccinated);
		List<Patient> patients2 = patientService.findPatientsByCovid19Vaccinated(covid19Vaccinated);
		patients2.forEach(p->{
			logger.info("Patient with covid19Vaccinated = " + covid19Vaccinated + " found : " + p);
		});
		
		// find entries by Boolean value
		String substring2 = "i";
		boolean covid19Vaccinated2 = true;
		logger.info("Find entries by Name contains = " + substring + " AND covid19Vaccinated = " + covid19Vaccinated);
		List<Patient> patients3 = patientService.findPatientsByNameContainsAndCovid19Vaccinated(substring2, covid19Vaccinated2);
		patients3.forEach(p->{
			logger.info("Patient found : " + p);
		});
		
		// delete entrie by Id
		Long id2 = 5L;
		logger.info("Delete entrie where Id = " + id2);
		try {
			patientService.deletePatientById(id2);
			Patient patient2 = null;

			patient2 = patientService.findPatientById(id2);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				logger.info("Delete OK");
			}
			else
				logger.error("Delete KO : " + e.getMessage());
			}
		
		// get all entries by Page
		int page = 1;
		int size = 2;
		logger.info("Get entries by page/size : " + (page+1) + "/" + size);
		Page<Patient> pagePatients = patientService.getListAllPatientsByPage(page, size);
		logger.info("Page : " + (page+1) + "/" + pagePatients.getTotalPages());
		pagePatients.forEach(p->{
			logger.info("Patient " + p);
		});
		
		// find entries by Name contains by Page
		int page1 = 1;
		int size1 = 2;
		String substring1 = "i";
		logger.info("Get entries by Name contains = " + substring1 +" by page/size : " + (page1+1) + "/" + size1);
		Page<Patient> pagePatients1 = patientService.findPatientsByNameContainsByPage(substring1, page1, size1);
		logger.info("Page : " + (page1+1) + "/" + pagePatients1.getTotalPages());
		pagePatients1.forEach(p->{
			logger.info("Patient " + p);
		}); 
		
		
		// Fetch all Patients with theirs rendezVous (LAZY)
		logger.info("** findAllPatientsWithTheirsRendezVous JPQL **");
		patientService.findAllPatientsWithTheirsRendezVous().forEach(p->{
			logger.info("Patient JPQL : " + p);
			//logger.info("RendezVous JPQL : " + 
			p.getListRendezVous().forEach(r->{
				logger.info("RendezVous JPQL : " +r);
				logger.info("Consultation : " +r.getConsultation());
			});

		});
		
		// Delete all Patients with theirs RDV and consultations
		logger.info("** Delete all Patients with theirs RDV and consultations (Cascade) **");
		//patientService.deleteAllPatients();
		logger.info("** Delete OK : commented action **");
		
		
		
		// Create some Users and Roles entries
		logger.info("** Create some Users and Roles entries **");
		userService.createUser(new User(null,"user1","12345",null));
		userService.createUser(new User(null,"user2","12345",null));
		userService.createUser(new User(null,"user3","12345",null));
		userService.createUser(new User(null,"user4","12345",null));
		userService.createUser(new User(null,"user5","12345",null));
		
		roleService.createRole(new Role(null, "gestionnaire", null));
		roleService.createRole(new Role(null, "admin", null));
		roleService.createRole(new Role(null, "superAdmin", null));
		
		logger.info("** Affect created users to created groups **");
		userService.addRoleToUser("user1", "gestionnaire");
		userService.addRoleToUser("user1", "admin");
		userService.addRoleToUser("user1", "superAdmin");
		userService.addRoleToUser("user2", "gestionnaire");
		userService.addRoleToUser("user2", "admin");
		userService.addRoleToUser("user3", "gestionnaire");
		userService.addRoleToUser("user4", "gestionnaire");
		userService.addRoleToUser("user5", "gestionnaire");
		
		logger.info("** Authenticate user1/12345 **");
		try {
			User user = userService.authenticate("user1", "12345");
			logger.info("** user = " + user);
			user.getRoles().forEach(r->{
				logger.info("** role = " + r.toString());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("** Spring boot AOP example **");
		roleService.getListAllRoles().forEach(r->{
			logger.info("** Role = "+r);
		});
		
		
		
		// Create some Etudiants and enseignant entries
		logger.info("** Create some Etudiants and Enseignants entries **");
		personneService.createEnseignant(new Enseignant(null, "Youssfi Mohamed", new Date(), "Programmation"));
		personneService.createEnseignant(new Enseignant(null, "CZ", new Date(), "Binance"));
		personneService.createEnseignant(new Enseignant(null, "Elon Musk", new Date(), "Automotive"));
		personneService.createEtudiant(new Etudiant(null, "Francois William", new Date(), 18));
		personneService.createEtudiant(new Etudiant(null, "Enric Laporte", new Date(), 14));
		personneService.createEtudiant(new Etudiant(null, "Roger Federer", new Date(), 17));
		
		logger.info("** Affichage des Etudiants and Enseignants entries **");
		personneService.getlistAllEnseignats().forEach(e->{
			logger.info("Enseignant : "+e);			
		});
		personneService.getlistAllEtudiants().forEach(e->{
			logger.info("Etudiant : "+e);			
		});
		
		
		// Preview some entries of Spring ApplicationContext
		// 7keya bidouna
		logger.info("** Preview some entries of Spring ApplicationContext **");
		logger.info("applicationContext.getDisplayName() = " + applicationContext.getDisplayName());
		logger.info("applicationContext.getId() = " + applicationContext.getId());
			
		UserService myBean = applicationContext.getBean(UserService.class);
		logger.info("UserService.getApplicationId = " + myBean.getApplicationId());

	}
}
