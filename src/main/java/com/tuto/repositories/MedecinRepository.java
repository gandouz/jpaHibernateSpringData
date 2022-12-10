package com.tuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
