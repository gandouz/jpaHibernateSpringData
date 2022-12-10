package com.tuto.services;

import java.util.List;

import com.tuto.entities.Consultation;

public interface IConsultationService {
	public Consultation createConsultation(Consultation consultation);
	public List<Consultation> getListAllConsultations();
	public Consultation findConsultationById(String id);

}
