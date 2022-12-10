package com.tuto.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.entities.RendezVous;
import com.tuto.repositories.RendezVousRepository;
import com.tuto.services.IRendezVousService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RendezVousService implements IRendezVousService{

	@Autowired
	RendezVousRepository rendezVousRepository;
	
	@Override
	public RendezVous createRendezVous(RendezVous rendezVous) {
		rendezVous.setId(UUID.randomUUID().toString());
		return rendezVousRepository.save(rendezVous);
	}

	@Override
	public List<RendezVous> getListAllRendezVous() {
		return rendezVousRepository.findAll();
	}

	@Override
	public RendezVous findRendezVousById(String id) {
		return rendezVousRepository.findById(id).get();
	}

}
