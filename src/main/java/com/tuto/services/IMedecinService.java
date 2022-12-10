package com.tuto.services;

import java.util.List;

import com.tuto.entities.Medecin;

public interface IMedecinService {
	public Medecin createMedecin(Medecin medecin);
	public List<Medecin> getListAllMedecins();
	public Medecin findMedecinById(Long id);

}
