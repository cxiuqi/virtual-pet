package com.example.pet.model.input;

import com.example.pet.model.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetInput {

	private String name;
	private String type;
	private Position position;
}
