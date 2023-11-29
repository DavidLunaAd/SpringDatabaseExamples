package com.curso.spring.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.curso.spring.models.Maquina;
import com.curso.spring.service.MaquinaService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {
	
	@Autowired
	private MaquinaService maquinaService;
	
	//Create a new maquina
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Maquina maquina){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(maquinaService.save(maquina));
	}
	
	//Read an maquina
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long maquinaId){
		Optional<Maquina> oMaquina = maquinaService.findById(maquinaId);
		
		if(!oMaquina.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
			return ResponseEntity.ok(oMaquina);
	}
	
	//Update an Maquina
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Maquina maquinaDetails, @PathVariable(value = "id") Long maquinaId){
		Optional<Maquina> maquina = maquinaService.findById(maquinaId);
		
		if(!maquina.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(maquinaDetails, maquina.get()); alternativa a los siguiente
		
		
		maquina.get().setNombre(maquinaDetails.getNombre());
		maquina.get().setUtilidad(maquinaDetails.getUtilidad());
		maquina.get().setSector(maquinaDetails.getSector());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(maquinaService.save(maquina.get()));
	}

	//Delete an Maquina
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long maquinaId){
		if(!maquinaService.findById(maquinaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		maquinaService.deleteById(maquinaId);
		return ResponseEntity.ok().build();
	}
	
	//Read all maquinas
	@GetMapping
	public List<Maquina> readAll(){
		
		//Convierte iterable en Lista con Stream
		List<Maquina> maquinas = StreamSupport
				.stream(maquinaService.findAll().spliterator(), false) //recorre iterable
				.collect(Collectors.toList());		// agrega a lista
		
		return maquinas;
	}
}
