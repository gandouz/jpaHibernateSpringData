package com.tuto.services3;

import java.util.List;

import com.tuto.entities3.Enseignant;
import com.tuto.entities3.Etudiant;

public interface IPersonneService {
	public Etudiant createEtudiant(Etudiant etudiant);
	public Enseignant createEnseignant(Enseignant enseignant);
	public List<Etudiant> getlistAllEtudiants();
	public List<Enseignant> getlistAllEnseignats();

}
