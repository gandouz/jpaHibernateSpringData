package com.tuto.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "T_MEDECINS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String mail;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	@OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<RendezVous> rendezVous;

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", nom=" + nom + ", mail=" + mail + ", specialite=" + specialite + "]";
	}
}
