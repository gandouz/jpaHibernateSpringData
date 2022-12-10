package com.tuto.entities3;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "T_PERSONNE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Personne {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String fullName;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", fullName=" + fullName + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
