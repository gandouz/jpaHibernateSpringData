package com.tuto.repositories3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.tuto.entities3.Personne;

@NoRepositoryBean
public interface PersonneRepository<Entity extends Personne> extends JpaRepository<Entity , Long>{

}
