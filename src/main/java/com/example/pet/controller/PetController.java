package com.example.pet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.model.Pet;
import com.example.pet.model.input.PetInput;
import com.example.pet.service.PetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

	private final PetService service;

	@PostMapping
	private Pet createNewPet(@RequestBody PetInput petInput) {
		return service.createPet(petInput);
	}
	
	@GetMapping
	private Pet getPet() {
		return service.getPet();
	}
	
	@PutMapping
	private Pet toggleWalk() {
		return service.toggleWalk();
	}
}