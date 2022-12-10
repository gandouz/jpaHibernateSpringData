package com.tuto.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.entities.Medecin;
import com.tuto.repositories.MedecinRepository;
import com.tuto.services.IMedecinService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedecinService implements IMedecinService{
	
	@Autowired
	MedecinRepository medecinRepository;
	
	@Override
	public Medecin createMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}

	@Override
	public List<Medecin> getListAllMedecins() {
		return medecinRepository.findAll();
	}

	@Override
	public Medecin findMedecinById(Long id) {
		return medecinRepository.findById(id).get();
	}

}
