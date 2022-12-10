package com.tuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, String>{

}
