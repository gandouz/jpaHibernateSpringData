package com.tuto.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;

@Entity @Table(name="T_RENDEZVOUS")
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
	@Id
	private String id;
	private Date date;
	@Enumerated(EnumType.STRING)
	private StatusRDV status;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Patient patient;
	@ManyToOne
	private Medecin medecin;
	//@ToString.Exclude
	@OneToOne(mappedBy = "rendezVous", cascade = CascadeType.ALL, orphanRemoval = true)
	private Consultation consultation;
	
	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", date=" + date + ", status=" + status + "]";
	}
}
