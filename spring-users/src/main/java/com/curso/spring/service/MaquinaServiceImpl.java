package com.curso.spring.service;

import java.util.Optional;

import com.curso.spring.models.Maquina;
import com.curso.spring.repository.MaquinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaquinaServiceImpl implements MaquinaService{

	@Autowired
	private MaquinaRepository maquinaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Maquina> findAll() {
		
		return maquinaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Maquina> findAll(Pageable pageable) {
		return maquinaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Maquina> findById(Long id) {
		return maquinaRepository.findById(id);
	}

	@Override
	@Transactional
	public Maquina save(Maquina maquina) {
		return maquinaRepository.save(maquina);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
	 maquinaRepository.deleteById(id);
		
	}

}
