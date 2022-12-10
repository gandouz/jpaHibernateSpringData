package com.tuto.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.entities.Consultation;
import com.tuto.repositories.ConsultationRepository;
import com.tuto.services.IConsultationService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultationService implements IConsultationService{

	@Autowired
	ConsultationRepository consultationRepository;

	@Override
	public Consultation createConsultation(Consultation consultation) {
		consultation.setId(UUID.randomUUID().toString());
		return consultationRepository.save(consultation);
	}

	@Override
	public List<Consultation> getListAllConsultations() {
		return consultationRepository.findAll();
	}

	@Override
	public Consultation findConsultationById(String id) {
		return consultationRepository.findById(id).get();
	}
	
	
}
