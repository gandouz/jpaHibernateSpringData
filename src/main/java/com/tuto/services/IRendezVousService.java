package com.tuto.services;

import java.util.List;

import com.tuto.entities.RendezVous;

public interface IRendezVousService {
	public RendezVous createRendezVous(RendezVous rendezVous);
	public List<RendezVous> getListAllRendezVous();
	public RendezVous findRendezVousById(String id);

}
