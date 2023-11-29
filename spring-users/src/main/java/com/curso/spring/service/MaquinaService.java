package com.curso.spring.service;

import java.util.Optional;

import com.curso.spring.models.Maquina;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaquinaService {
	
	public Iterable<Maquina> findAll();
	
	public Page<Maquina> findAll(Pageable pageable);
	
	public Optional<Maquina> findById(Long id);
	
	public Maquina save(Maquina maquina);
	
	public void deleteById(Long id);
	

}
