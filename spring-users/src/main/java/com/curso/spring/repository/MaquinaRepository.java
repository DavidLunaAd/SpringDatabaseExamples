package com.curso.spring.repository;

import com.curso.spring.models.Maquina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long>{
	

}
