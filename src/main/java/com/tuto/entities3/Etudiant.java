package com.tuto.entities3;

import java.util.Date;

import com.tuto.entities3.Enseignant.EnseignantBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "T_ETUDIANT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant extends Personne {
	private double note;

	@Override
	public String toString() {
		return "Etudiant [note=" + note + ", toString()=" + super.toString() + "]";
	}
	
	@Builder
	public Etudiant(Long id, String fullName, Date birthDate, double note) {
		super(id, fullName, birthDate);
		this.note = note;
	}
	
}
