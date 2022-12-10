package com.tuto.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "T_CONSULTATIONS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
	@Id
	private String id;
	private Date dateConsultation;
	private String rapport;
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private RendezVous rendezVous;

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", dateConsultation=" + dateConsultation + ", rapport=" + rapport + "]";
	}
}
