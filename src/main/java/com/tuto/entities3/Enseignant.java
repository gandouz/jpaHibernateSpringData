package com.tuto.entities3;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_ENSEIGNANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant extends Personne {
	private String matiere;

	@Override
	public String toString() {
		return "Enseignant [matiere=" + matiere + ", toString()=" + super.toString() + "]";
	}

	@Builder
	public Enseignant(Long id, String fullName, Date birthDate, String matiere) {
		super(id, fullName, birthDate);
		this.matiere = matiere;
	}

}
