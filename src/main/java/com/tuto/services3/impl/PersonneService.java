package com.tuto.services3.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.entities3.Enseignant;
import com.tuto.entities3.Etudiant;
import com.tuto.repositories3.EnseignantRepository;
import com.tuto.repositories3.EtudiantRepository;
import com.tuto.services3.IPersonneService;

@Service
public class PersonneService implements IPersonneService {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public Etudiant createEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public Enseignant createEnseignant(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);

	}

	@Override
	public List<Etudiant> getlistAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public List<Enseignant> getlistAllEnseignats() {
		return enseignantRepository.findAll();
	}

}
