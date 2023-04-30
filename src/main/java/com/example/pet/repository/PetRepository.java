package com.example.pet.repository;

import org.springframework.stereotype.Component;

import com.example.pet.model.Pet;

import lombok.Data;

@Data
@Component
public class PetRepository {
	
	private Pet pet;
}
