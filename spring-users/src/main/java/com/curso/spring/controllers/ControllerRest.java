package com.curso.spring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.curso.spring.models.Maquina;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControllerRest {
	
	@Value("${indice.hola2}")
	private String hola2;
	
	@GetMapping("/ayuda")
	public String comienzo(Model model){
		String hola = "Hola Spring Boot Ayuuuudame";
		
		Maquina maquina = new Maquina();
		maquina.setNombre("Pc fichaje");
		maquina.setSector("Recursos Humanos");
		maquina.setUtilidad("Varias");
		
		Maquina maquina2 = new Maquina();
		maquina2.setNombre("Pc Jose");
		maquina2.setSector("Recursos");
		maquina2.setUtilidad("Usos");
		
		List maquinas = Arrays.asList();
		
		
		log.info("Inicio controller ayudA!!");
		
		model.addAttribute("hola", hola);
		model.addAttribute("hola2", hola2);
//		model.addAttribute("maquina", maquina);
		model.addAttribute("maquinas", maquinas);
		return "indice";
		
		
	}

}
